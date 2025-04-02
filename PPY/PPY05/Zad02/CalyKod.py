import os
import shutil

def stworz_folder():
    nazwa_folderu = input("Podaj nazwe folderu")
    os.mkdir(nazwa_folderu)

def stworz_zagniezdzony_folder():
    nazwa_folderu = input("Podaj nazwy folderów np:\n- "
                          "folder1/folder2/folder3")
    os.makedirs(nazwa_folderu)

def usun_folder_z_zawartoscia_lub_bez():
    nazwa_folderu = input("Podaj nazwe folderu")
    shutil.rmtree(nazwa_folderu)

def czy_folder_istnieje():
    nazwa_folderu = input("Podaj nazwe folderu")
    print(os.path.exists(nazwa_folderu))

def zmien_nazwe():
    nazwa_folderu = input("Podaj nazwe folderu którego nazwe chcesz zmienic")
    nazwa_nowa = input("Podaj nową nazwe dla folderu")
    os.rename(nazwa_folderu, nazwa_nowa)



while True:
    folderKomenda = input("\nUtwórz folder -> (1)\n"
                          "Utwórz grupe folderów -> (2)\n"
                          "Usuń folder -> (3)\n"
                          "Sprawdz czy folder istnieje -> (4)\n"
                          "Zmien nazwe folderu -> (5)\n"
                          "Wyjście -> (e)\n")

    if folderKomenda == "1":
        try:
            stworz_folder()
        except FileExistsError as e:
            print("Taki folder juz istnieje", e)
    elif folderKomenda == "2":
        try:
            stworz_zagniezdzony_folder()
        except FileExistsError as e:
            print("Taki folder juz istnieje", e)
    elif folderKomenda == "3":
        try:
            usun_folder_z_zawartoscia_lub_bez()
        except FileNotFoundError as e:
            print("Taki folder nie istnieje", e)
    elif folderKomenda == "4":
        czy_folder_istnieje()
    elif folderKomenda == "5":
        try:
            zmien_nazwe()
        except FileNotFoundError as e:
            print("Taki folder nie istnieje", e)
    elif folderKomenda.lower() == "e":
        break