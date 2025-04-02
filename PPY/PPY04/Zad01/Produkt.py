class Produkt:

    def __init__(self, nazwa, data_waznosci, kod_kreskowy):
        self.nazwa = nazwa
        self.data_waznosci = data_waznosci
        self.kod_kreskowy = kod_kreskowy
    
    def __str__(self):
        return f"Nazwa: {self.nazwa}\nData ważnosci: {self.data_waznosci}\nKod: {self.kod_kreskowy}"

    @staticmethod
    def baza():
        p1 = Produkt("Mleko","03-03-2025","8394736253847")
        p2 = Produkt("Chipsy","25-08-2027","9604938596023")
        p3 = Produkt("Herbata","14-01-2030","0982384750991")
        p4 = Produkt("Ser","09-06-2024","6574019283749")
        p5 = Produkt("Kapusta","02-28-2025","11039948362739")
        p6 = Produkt("Ketchup","18-12-2028","7748399472644")
        lista = [p1, p2, p3, p4, p5, p6]
        for p in lista:
            print(p)
            print("=" * 80)



