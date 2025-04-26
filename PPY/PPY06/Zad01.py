gwiazdki_ilosc = int(input("Podaj ilosc gwiazdek"))
kratki_ilosc = int(input("Podaj ilosc kratek"))
dolary_ilosc = int(input("Podaj ilosc dolarów"))

wszystkie_znaki = gwiazdki_ilosc + kratki_ilosc + dolary_ilosc

for i in range(wszystkie_znaki):
    kolumna1 = "*" if i < gwiazdki_ilosc else " "
    kolumna2 = "#" if i < kratki_ilosc else " "
    kolumna3 = "$" if i < dolary_ilosc else " "

    print(f"{kolumna1} {kolumna2} {kolumna3}")