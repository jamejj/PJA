import tkinter as tk

class TicTacToe:

    def __init__(self, root):
        self.window = root
        self.window.title("Tic Tac Toe")
        self.window.geometry("270x320")
        self.window.resizable(False, False)
        self.window.configure(bg="black")

        self.obecny_gracz = "X"
        self.plansza = ["" for _ in range(9)]
        self.przyciski = []

        self.status = tk.Label(self.window, text="Ruch gracza: X", fg="white", bg="black", font=("Arial", 15))
        self.status.place(x=75, y=280)

        self.stworz_plansze()

    def stworz_plansze(self):
        for i in range(9):
            b = tk.Button(self.window, text="", font=("Arial", 20), width=5, height=2, command=lambda i=i: self.click(i))
            b.grid(row=i//3, column=i%3)
            self.przyciski.append(b)

    def zwyciezca_sprawdz(self):

        wygrywajace_pozycje = [(0,1,2), (3,4,5), (6,7,8),(0,3,6), (1,4,7), (2,5,8),(0,4,8), (2,4,6)]
        
        for i, j, k in wygrywajace_pozycje:
            if self.plansza[i] == self.plansza[j] == self.plansza[k] != "":
                return self.plansza[i]
        if "" not in self.plansza:
            return "Remis"

    def click(self, index):
        if self.plansza[index] == "":
            self.plansza[index] = self.obecny_gracz
            self.przyciski[index].config(text=self.obecny_gracz)
            winner = self.zwyciezca_sprawdz()
            if winner:
                if winner == "Remis":
                    self.status.config(text="REMIS")
                else:
                    self.status.config(text=f"Wygrana: {winner}!")
                for btn in self.przyciski:
                    btn.config(state="disabled")
            else:
                self.obecny_gracz = "O" if self.obecny_gracz == "X" else "X"
                self.status.config(text=f"Ruch gracza: {self.obecny_gracz}")

window = tk.Tk()
gra = TicTacToe(window)
window.mainloop()