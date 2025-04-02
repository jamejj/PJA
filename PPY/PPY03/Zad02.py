listaSklepy = ["Lidl","Zabka","Biedronka","Carrefour"]
listaSlownikProdukty = [
    {"Nazwa produktu" : "maslo", "Producent" : "Piatnica", "Data waznosci" : "2025-05-05", "Kategoria" : "Nabial"},
    {"Nazwa produktu": "mleko", "Producent": "Mlekovita", "Data waznosci": "2025-12-12", "Kategoria": "Nabial"},
    {"Nazwa produktu": "piwo", "Producent": "Dzik", "Data waznosci": "2026-01-00", "Kategoria": "Napoje"},
    {"Nazwa produktu": "kapusta", "Producent": "Kapusty", "Data waznosci": "2025-04-04", "Kategoria": "Warzywa"}
]
listaCeny = [3.30, 8.80, 12.75, 6.66]
listaKlienci = ["Jan", "Joanna", "Ferdynand"]


sklepyEven = [listaSklepy[i] for i in range(len(listaSklepy)) if i % 2 == 1]

produkty = [listaSlownikProdukty[i]["Nazwa produktu"] for i in range(len(listaSlownikProdukty)) if i % 6 == 0]

wynik = list(zip(sklepyEven, produkty))

print("Wynik:", *wynik)

listCeny = [listaSlownikProdukty[i]["Nazwa produktu"] for i in range(len(listaSlownikProdukty))]
listCeny2 = [listaCeny[i] for i in range(len(listaCeny))]

listaProduktCena = list(zip(listCeny, listCeny2[::-1]))

print(*listaProduktCena)
