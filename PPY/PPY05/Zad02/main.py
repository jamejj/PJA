from PPY.PPY05 import *



while True:
    folderKomenda = input("\nUtwórz folder -> (1)\n"
                          "Utwórz grupe folderów -> (2)\n"
                          "Usuń folder -> (3)\n"
                          "Sprawdz czy folder istnieje -> (4)\n"
                          "Zmien nazwe folderu -> (5)\n"
                          "Wyjście -> (e)\n")

    if folderKomenda == "1":
        try:
            stworz_folder() # type: ignore
        except FileExistsError as e:
            print("Taki folder juz istnieje", e)
    elif folderKomenda == "2":
        try:
            stworz_zagniezdzony_folder() # type: ignore
        except FileExistsError as e:
            print("Taki folder juz istnieje", e)
    elif folderKomenda == "3":
        try:
            usun_folder_z_zawartoscia_lub_bez() # type: ignore
        except FileNotFoundError as e:
            print("Taki folder nie istnieje", e)
    elif folderKomenda == "4":
        czy_folder_istnieje() # type: ignore
    elif folderKomenda == "5":
        try:
            zmien_nazwe() # type: ignore
        except FileNotFoundError as e:
            print("Taki folder nie istnieje", e)
    elif folderKomenda.lower() == "e":
        break