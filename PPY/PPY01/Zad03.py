bin_in = input("Podaj liczbę w systemie dwójkowym: ")
print("Podana liczba w systemie dwójkowym: ", bin_in)

#Zamiana z binarnego na dziesiętny -> int(nasza_liczba_bin,2)
bin_int = int(bin_in, 2)
print("Zmienna bin zawiera liczbę ", bin_in, " zapisaną w systemie dwójkowym, "
                                             "a po konwersji na system dziesiętny je wartość wynosi ", bin_int)
print("=" * 80)

oct_in = input("Podaj liczbę w systemie osemkowym: ")
print("Podana liczba w systemie osemkowym: ", oct_in)
oct_int = int(oct_in, 8)
print("Zmienna oct zawiera liczbę ", oct_in, " zapisaną w systemie ósemkowym, "
                                             "a po konwersji na system dziesiętny je wartość wynosi ", oct_int)
print("=" * 80)

hex_in = input("Podaj liczbę w systemie szesnastkowym: ")
print("Podana liczba w systemie szesnastkowym: ", hex_in)
hex_int = int(hex_in, 16)
print("Zmienna hex zawiera liczbę ", hex_in, " zapisaną w systemie szesnastkowym, "
                                             "a po konwersji na system dziesiętny je wartość wynosi ", hex_int)