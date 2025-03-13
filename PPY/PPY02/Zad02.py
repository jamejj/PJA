#Lista 20 elementów
l = list(range(1,21))

"""
#Metoda z pętlą
#Nowa pusta lista do której dodamy elementy których indeksy są liczbami pierwszymi
l2 = []

for i in range(len(l)):
    if i > 1:  
        for j in range(2, i): 
            if i % j == 0:
                break
        else:
            l2.append(l[i])

print(l2)
"""

#Metoda z List Comprehension

#any sprawdza czy w zestawie iteracji danej liczby wszystkie wyniki dadzą false jezeli tak to liczba jest pierwsza
l2 = [l[i] for i in range(len(l)) if i > 1 and not any(i % j == 0 for j in range(2, i))]
print(l2)



