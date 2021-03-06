
#property indicator_separate_window
#property indicator_buffers 2
#property indicator_plots   2
#property indicator_type1   DRAW_LINE
#property indicator_type2   DRAW_LINE
#property indicator_color1  Red
#property indicator_color2  DodgerBlue

input int period=5;
int Handle;
int i;
int h;
double    ExtBuffer[];
double    SignBuffer[];
datetime Date1;
datetime Date0;
string File_Name="Indicator.csv";

//+------------------------------------------------------------------+
//| Custom indicator initialization function                         |
//+------------------------------------------------------------------+
void OnInit()
  {
   SetIndexBuffer(0,ExtBuffer,INDICATOR_DATA);
   SetIndexBuffer(1,SignBuffer,INDICATOR_DATA);
   IndicatorSetInteger(INDICATOR_DIGITS,5);
   Handle=FileOpen(File_Name,FILE_CSV|FILE_SHARE_READ|FILE_ANSI|FILE_COMMON,";");
  }
//+------------------------------------------------------------------+
//| Relative Strength Index                                          |
//+------------------------------------------------------------------+
int OnCalculate(const int rates_total,
                const int prev_calculated,
                const int begin,
                const double &price[])
  {
   MqlDateTime stm;
   Date0=StringToTime(FileReadString(Handle));
   i=iBarShift(NULL,PERIOD_H1,Date0,false);
   Handle=FileOpen(File_Name,FILE_CSV|FILE_SHARE_READ|FILE_ANSI|FILE_COMMON,";");
   ArraySetAsSeries(ExtBuffer,true);
   ArraySetAsSeries(SignBuffer,true);

   while(!FileIsEnding(Handle) && !IsStopped())
     {
      Date1=StringToTime(FileReadString(Handle));
      ExtBuffer[i]=StringToDouble(FileReadString(Handle));
      h=period-1;
      if(i>=0)
        {
         while(h>=0)
           {
            SignBuffer[i]=SignBuffer[i]+ExtBuffer[i+h];
            h--;
           }
        }
      SignBuffer[i]=SignBuffer[i]/period;
      TimeToStruct(Date1,stm);
      i--;
     }
   FileClose(Handle);
   return(rates_total);
  }
//+------------------------------------------------------------------+
