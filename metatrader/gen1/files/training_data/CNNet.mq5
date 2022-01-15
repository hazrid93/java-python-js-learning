# script to create array of test data
#property strict
#property script_show_inputs

input string Date="2017.01.02 00:00";
input string DateOut="2018.12.13 23:00";
input string DateTest="2019.01.02 00:00";
input string Dataset="Train";

string Date1;
int count,countB,countS;
int day;
double DibMin;
double DibMax;
int HandleDate;
long WIDTH;
long HEIGHT;
//+------------------------------------------------------------------+
//| Script program start function                                    |
//+------------------------------------------------------------------+
void OnStart()
  {
//---
   MqlDateTime stm;
   ChartSetInteger(0,CHART_SHIFT,false);
   ChartSetInteger(0,CHART_AUTOSCROLL,false);
   ChartSetInteger(0,CHART_SHOW_OBJECT_DESCR,false);
   //ChartSetInteger(0,CHART_HEIGHT_IN_PIXELS,470);
   WIDTH=ChartGetInteger(0,CHART_WIDTH_IN_PIXELS);
   ChartSetInteger(0,CHART_SHOW_PRICE_SCALE,false);

   if(Dataset=="Test")
     {
      HandleDate=FileOpen(Symbol()+"Date.csv",FILE_CSV|FILE_READ|FILE_WRITE|FILE_ANSI,";");
      ChartNavigate(0,CHART_END,-(iBarShift(NULL,PERIOD_H1,StringToTime(DateTest))));
      Sleep(1000);

      for(int i=iBarShift(NULL,PERIOD_H1,StringToTime(DateTest)); i>0; i--)
        {
         Date1=TimeToString(iTime(NULL,PERIOD_H1,i));
         if(DateTest<=Date1)
           {
            if(ChartNavigate(0,CHART_END,-i))
              {
               Sleep(20);
               if(ChartScreenShot(0, (string)count + ".png", (int)WIDTH, (int)WIDTH, ALIGN_LEFT))
                 {
                  FileWrite(HandleDate,TimeToString(iTime(NULL,PERIOD_H1,i)));
                  count++;
                  Sleep(20);
                 }
              }
           }
        }
     }
   if(Dataset=="Train")
     {
      ChartNavigate(0,CHART_END,-iBarShift(NULL,PERIOD_H1,StringToTime(Date)));
      Sleep(1000);
      for(int i=iBarShift(NULL,PERIOD_H1,StringToTime(Date)); i>=iBarShift(NULL,PERIOD_H1,StringToTime(DateOut)); i--)
        {
         TimeToStruct(iTime(NULL,PERIOD_H1,i),stm);
         Date1=TimeToString(iTime(NULL,PERIOD_H1,i));
         if(DateOut>=Date1 && Date<=Date1)
           {
            if(ChartNavigate(0,CHART_END,-i))
              {
               Sleep(20);
               if(day != stm.day)
                 {
                  FileCopy("Sell" + (string)countS + ".png", 0, "Buy" + (string)(countB+1) + ".png", FILE_REWRITE);
                  FileDelete("Sell" + (string)countS + ".png", 0);
                  FileCopy("Buy" + (string)countB + ".png", 0, "Sell" + (string)(countS+1) + ".png", FILE_REWRITE);
                  FileDelete("Buy" + (string)countB + ".png", 0);
                  countB ++;
                  countS ++;
                 }
               day = stm.day;
               if(stm.hour == 0)
                 {
                  DibMin = iOpen(NULL, PERIOD_H1, i);
                  DibMax = iOpen(NULL, PERIOD_H1, i);
                 }
               if(iLow(NULL, PERIOD_H1, i+1) < DibMin)
                 {
                  DibMin = iLow(NULL, PERIOD_H1, i+1);
                  countS ++;
                  ChartScreenShot(0, "Sell" + (string)countS + ".png", (int)WIDTH, (int)WIDTH, ALIGN_LEFT);
                 }
               if(iHigh(NULL, PERIOD_H1, i+1) > DibMax)
                 {
                  DibMax = iHigh(NULL, PERIOD_H1, i+1);
                  countB ++;
                  ChartScreenShot(0, "Buy"  +(string)countB + ".png", (int)WIDTH, (int)WIDTH, ALIGN_LEFT);
                 }
               Sleep(20);
              }
           }
         else
            break;
        }
     }
//---
  }
//+------------------------------------------------------------------+
