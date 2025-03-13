"""
#SposóbNr1
#Stworzenie listy sekwencyjnej dla ciągu znaków
l1 = [i for i in "ABCDEFGHIJ"]
print(l1)
"""
#SposóbNr2
#Stworzenie listy sekwencyjnej w przedziale 65-75 (A-J) i przekonwertowanie jej na char
print("ListaNr1: ")
l2 = [chr(i) for i in list(range(65,75))]
print(l2)

print("ListaNr2: ")
l3 = list(range(1,11))
print(l3)

"""
#Set
#s1 = {l2,l3} -> TypeError: unhashable type: 'list'
s1 = {tuple(l2),tuple(l3)}
print(s1)
"""

#Słownik (dict), zip tworzy pary klucz : wartosc
print("Słownik: ")
s2 = dict(zip(l2, l3))
print(s2)