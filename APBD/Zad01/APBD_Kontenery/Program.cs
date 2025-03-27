// See https://aka.ms/new-console-template for more information

using APBD_Kontenery;

var kontenerNaPlyny = new KontenerNaPlyny(0,20,1000,5,100,true);
kontenerNaPlyny.Zaladuj(20);
kontenerNaPlyny.Oproznij();


var kontenerNaPlyny2 = new KontenerNaPlyny(0,20,1000,5,100,false);
kontenerNaPlyny2.Zaladuj(20);
kontenerNaPlyny2.Zaladuj(20);
kontenerNaPlyny2.WypiszInfo();
kontenerNaPlyny2.Oproznij();

Console.WriteLine("===============================");


var kontenerNaGaz = new KontenerNaGaz(0,5,1000,5,100,100_000);
kontenerNaGaz.Zaladuj(30);
kontenerNaGaz.Oproznij();
kontenerNaGaz.WypiszInfo();

Console.WriteLine("===============================");

var kontenerChlodniczyBanany = new KontenerChlodniczy(0,5,1000,10,1000,"Bananas",13.3);
kontenerChlodniczyBanany.Zaladuj("Bananas",30);
kontenerChlodniczyBanany.Oproznij();

Console.WriteLine("===============================");


var statek = new Statek(80,50,10000);
statek.ZaładujKontenerNaStatek(kontenerNaGaz);
statek.ZaładujKontenerNaStatek(kontenerChlodniczyBanany);
statek.StatekInfo();
statek.UsunKontener("KON-G-3");

Console.WriteLine("===============================");

var statek2 = new Statek(80,50,20000);
statek.PrzeniesKontenerNa(statek2, "KON-C-4");
statek2.StatekInfo();

Console.WriteLine("===============================");


var kontenerChlodniczyCzekolada = new KontenerChlodniczy(0,5,1000,10,1000,"Chocolate",18);
kontenerChlodniczyBanany.Zaladuj("Chocolate",30);
kontenerChlodniczyBanany.Oproznij();

