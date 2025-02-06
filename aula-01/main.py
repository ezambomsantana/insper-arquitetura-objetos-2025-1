var1 = "texto"
print(var1)

var1 = len(var1)
print(var1)

if var1 > 10:
    print("maior que 10")
elif var1 > 5:
    print("maior que 5")
else:
    print("menor que 5")

var1 = [1, 2, 3, 4, 5]
for num in var1:
    print(num)

for i in range(1, 20):
    print(i)

for idx, x in enumerate(var1):
    print(idx, x)

var1.append(20)
print(var1)


var1 = {1, 5, 3, 1}
print(var1)

var1 = {'a': 1, 'b': 2}
print(var1)

var1 = input("nome: ")
print(var1)

var1 = {
    'nome': 'Filme 1',
    'ano': 20202,
    'atores': [
        'ator-1', 'ator-2'
    ]
}
print(var1)

class Filme:
  def __init__(self, nome, ano):
    self.nome = nome
    self.ano = ano
    self.atores = []

  def get_nome(self):
    print(self.name)

  def adiciona_ator(self, ator):
    print(ator)

filme = Filme("Teste", 2023)
filme.adiciona_ator("ator-1")
filme.adiciona_ator("ator-2")

print(filme.nome)
