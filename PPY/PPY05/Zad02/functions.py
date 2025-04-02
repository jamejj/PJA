import os
import shutil

class FolderManager:

    def stworz_folder(self):
        nazwa_folderu = input("Podaj nazwe folderu")
        os.mkdir(nazwa_folderu)

    def stworz_zagniezdzony_folder(self):
        nazwa_folderu = input("Podaj nazwy folderów np:\n- "
                              "folder1/folder2/folder3")
        os.makedirs(nazwa_folderu)

    def usun_folder_z_zawartoscia_lub_bez(self):
        nazwa_folderu = input("Podaj nazwe folderu")
        shutil.rmtree(nazwa_folderu)

    def czy_folder_istnieje(self):
        nazwa_folderu = input("Podaj nazwe folderu")
        print(os.path.exists(nazwa_folderu))

    def zmien_nazwe(self):
        nazwa_folderu = input("Podaj nazwe folderu którego nazwe chcesz zmienic")
        nazwa_nowa = input("Podaj nową nazwe dla folderu")
        os.rename(nazwa_folderu, nazwa_nowa)