# Toteutusdokumentti Labyrintti

Tietorakenteiden harjoitusty�n aiheena Labyrintti, jota p��tin l�hte� ratkaisemaan ensin A* -reitinhakualgoritmin avulla.

A*-hakua l�hdin toteuttamaan Wikipedian artikkelin pseudokoodin perusteella (1), ottaen huomioon tietorakenteet ja algoritmit kurssilla k�sitellyn materiaalin (2). A* -algoritmin aikavaativuus on artikkelin mukaan suurimmillaan exponentiaalinen, mik�li maaliin voi p��st�. Jos maaliin ei p��se ja labyrintti on ��ret�n algoritmikin jatkuu loputtomasti. Parhaimmillaan aikavaativuus on polynominen kun etsint�-avaruus muodostaa puun, maaleja on yksi ja heuristiikkafunktio h(x) noudattaa seuraavaa ehtoa:

| h(x) - h*(x) | = O(log h*(x))

A* -haku l�ytyy ohjelmasta luokasta Astar. Omana prioriteettijonon toteutuksena toteutin minimikeon, joka l�ytyy luokasta Keko. Astar luokassa on my�s oman minimikeon suorituksen ohella toteutettu suoritus A* haulla Javan PrioritQueueta k�ytt�m�ll�, jotta n�iden suorituskyky� voi vertailla.

A* -haun p��tytty� polku rakennetaan Pino-luokan tietorakenteen avulla, joka pohjautuu Tira-kurssin materiaaliin. Labyrintiss� olevat ruudut on tallennettu Solmu luokan avulla.
Solmu pit�� sis�ll��n sen koordinaatit labyrintiss�, matkan l�ht�solmuun ja arvion l�ht�solmusta maalisolmuun, onko solmussa k�yty, sek� voiko solmun l�pi kulkea vai onko siin� este.

# Suoritustuloksia

A* -haku omalla keolla 1000000x:
122.629704 ms

A* -haku Javan Priority Queuella 1000000x:
121.860499 ms

# K�ytt�liittym�

Tekstik�ytt�liittym�n avulla voi luoda satunnaisen labyrintin ja ratkaista sen A* -haulla. Lis�ksi voi suorittaa suorituskykytestej� verraten nopeutta omien ja valmiiden tietorakenteiden avulla.

# Puutteet ja mahdollinen parantelu

Joillain kohdin haku tuntuu laajentuvan l�ht�solmun l�hell� liian laajalle alueelle eli hakua voi varmaankin viel� parantaa. Hyv� olisi my�s jos ohjelmaan voisi helposti lis�t� omia labyrinttej� ratkottavaksi. T�ll� hetkell� voi vain k�ytt�� valmista testaukseen k�ytett�v�� labyrintti� tai satunnaisesti arvottua.

 
(1) https://en.wikipedia.org/wiki/A*_search_algorithm
(2) Tietorakenteet ja algoritmit -kurssin materiaali 