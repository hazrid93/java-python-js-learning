
#property strict

#include<Trade\Trade.mqh>

CTrade  trade;

input int period=5;
input int H1;
input int H2;
input int H3;
input int H4;
input int LossBuy;
input int ProfitBuy;
input int LossSell;
input int ProfitSell;

ulong TicketBuy1;
ulong TicketSell0;

datetime Count;

double Per;
double Buf_0[];
double Buf_1[];
bool send1;
bool send0;

int h=4;
int k;
int K;
int bars;
int Handle;
//+------------------------------------------------------------------+
//| Expert initialization function                                   |
//+------------------------------------------------------------------+
int OnInit()
  {
//---

   Handle=FileOpen("Indicator.csv",FILE_CSV|FILE_SHARE_READ|FILE_ANSI|FILE_COMMON,";");

   while(!FileIsEnding(Handle)&& !IsStopped())
     {
      StringToTime(FileReadString(Handle));
      bars++;
     }
   FileClose(Handle);
   ArrayResize(Buf_0,bars);
   ArrayResize(Buf_1,bars);
   Handle=FileOpen("Indicator.csv",FILE_CSV|FILE_SHARE_READ|FILE_ANSI|FILE_COMMON,";");

   while(!FileIsEnding(Handle)&& !IsStopped())
     {
      Count=StringToTime(FileReadString(Handle));
      Buf_0[k]=StringToDouble(FileReadString(Handle));
      h=period-1;
      if(k>=h)
        {
         while(h>=0)
           {
            Buf_1[k]=Buf_1[k]+Buf_0[k-h];
            h--;
           }
         Buf_1[k]=Buf_1[k]/period;
        }
      k++;
     }
   FileClose(Handle);

   int deviation=10;
   trade.SetDeviationInPoints(deviation);
   trade.SetTypeFilling(ORDER_FILLING_RETURN);
   trade.SetAsyncMode(true);

//---
   return(INIT_SUCCEEDED);
  }

//+------------------------------------------------------------------+
//| Expert deinitialization function                                 |
//+------------------------------------------------------------------+
void OnDeinit(const int reason)
  {
//---

  }
//+------------------------------------------------------------------+
//| Expert tick function                                             |
//+------------------------------------------------------------------+
void OnTick()
  {
//---
   MqlDateTime stm;
   TimeToStruct(TimeCurrent(),stm);

   int    digits=(int)SymbolInfoInteger(_Symbol,SYMBOL_DIGITS);
   double point=SymbolInfoDouble(_Symbol,SYMBOL_POINT);
   double PriceAsk=SymbolInfoDouble(_Symbol,SYMBOL_ASK);
   double PriceBid=SymbolInfoDouble(_Symbol,SYMBOL_BID);

   double SL1=NormalizeDouble(PriceBid-LossBuy*point,digits);
   double TP1=NormalizeDouble(PriceAsk+ProfitBuy*point,digits);
   double SL0=NormalizeDouble(PriceAsk+LossSell*point,digits);
   double TP0=NormalizeDouble(PriceBid-ProfitSell*point,digits);

   if(LossBuy==0)
      SL1=0;

   if(ProfitBuy==0)
      TP1=0;

   if(LossSell==0)
      SL0=0;

   if(ProfitSell==0)
      TP0=0;

//---------Buy1
   if(send1==false && K>0 && Buf_0[K-1]>Buf_1[K-1] && Buf_0[K]<Buf_1[K] && iLow(NULL,PERIOD_H1,1)<iLow(NULL,PERIOD_H1,2) && stm.hour>H1 && stm.hour<H2 && H1<H2)
     {
      send1=trade.PositionOpen(_Symbol,ORDER_TYPE_BUY,1,PriceAsk,SL1,TP1);
      TicketBuy1 = trade.ResultDeal();
     }

   if(send1==true && K>0 && Buf_0[K-1]<Buf_1[K-1] && Buf_0[K]>Buf_1[K] && iHigh(NULL,PERIOD_H1,1)>iHigh(NULL,PERIOD_H1,2))
     {
      trade.PositionClose(TicketBuy1);
      send1=false;
     }

//---------Sell0

   if(send0==false && K>0 && Buf_0[K-1]<Buf_1[K-1] && Buf_0[K]>Buf_1[K] && iHigh(NULL,PERIOD_H1,1)>iHigh(NULL,PERIOD_H1,2) && stm.hour>H3 && stm.hour<H4 && H3<H4)
     {
      send0=trade.PositionOpen(_Symbol,ORDER_TYPE_SELL,1,PriceBid,SL0,TP0);
      TicketSell0 = trade.ResultDeal();
     }

   if(send0==true && K>0 && Buf_0[K-1]>Buf_1[K-1] && Buf_0[K]<Buf_1[K] && iLow(NULL,PERIOD_H1,1)<iLow(NULL,PERIOD_H1,2))
     {
      trade.PositionClose(TicketSell0);
      send0=false;
     }
   K++;
  }
//+------------------------------------------------------------------+
//+------------------------------------------------------------------+
//| Tester function                                                  |
//+------------------------------------------------------------------+
double OnTester()
  {
//---
   double ret=0.0;
//---

//---
   return(ret);
  }
//+------------------------------------------------------------------+
