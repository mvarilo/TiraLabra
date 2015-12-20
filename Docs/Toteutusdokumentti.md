# Toteutusdokumentti Labyrintti

Tietorakenteiden harjoitustyön aiheena Labyrintti, jota päätin lähteä ratkaisemaan ensin A* -reitinhakualgoritmin avulla.

A*-hakua lähdin toteuttamaan Wikipedian artikkelin pseudokoodin perusteella (1), ottaen huomioon tietorakenteet ja algoritmit kurssilla käsitellyn materiaalin (2). A* -algoritmin aikavaativuus on artikkelin mukaan suurimmillaan exponentiaalinen, mikäli maaliin voi päästä. Jos maaliin ei pääse ja labyrintti on ääretön algoritmikin jatkuu loputtomasti. Parhaimmillaan aikavaativuus on polynominen kun etsintä-avaruus muodostaa puun, maaleja on yksi ja heuristiikkafunktio h(x) noudattaa seuraavaa ehtoa:

| h(x) - h*(x) | = O(log h*(x))

A* -haku löytyy ohjelmasta luokasta Astar. Omana prioriteettijonon toteutuksena toteutin minimikeon, joka löytyy luokasta Keko. Astar luokassa on myös oman minimikeon suorituksen ohella toteutettu suoritus A* haulla Javan PrioritQueueta käyttämällä, jotta näiden suorituskykyä voi vertailla.

A* -haun päätyttyä polku rakennetaan Pino-luokan tietorakenteen avulla, joka pohjautuu Tira-kurssin materiaaliin. Labyrintissä olevat ruudut on tallennettu Solmu luokan avulla.
Solmu pitää sisällään sen koordinaatit labyrintissä, matkan lähtösolmuun ja arvion lähtösolmusta maalisolmuun, onko solmussa käyty, sekä voiko solmun läpi kulkea vai onko siinä este.

# Suoritustuloksia

A* -haku omalla keolla 1000000x:
122.629704 ms

A* -haku Javan Priority Queuella 1000000x:
121.860499 ms

# Käyttöliittymä

Tekstikäyttöliittymän avulla voi luoda satunnaisen labyrintin ja ratkaista sen A* -haulla. Lisäksi voi suorittaa suorituskykytestejä verraten nopeutta omien ja valmiiden tietorakenteiden avulla.

# Puutteet ja mahdollinen parantelu

Joillain kohdin haku tuntuu laajentuvan lähtösolmun lähellä liian laajalle alueelle eli hakua voi varmaankin vielä parantaa. Hyvä olisi myös jos ohjelmaan voisi helposti lisätä omia labyrinttejä ratkottavaksi. Tällä hetkellä voi vain käyttää valmista testaukseen käytettävää labyrinttiä tai satunnaisesti arvottua.

 
(1) https://en.wikipedia.org/wiki/A*_search_algorithm
(2) Tietorakenteet ja algoritmit -kurssin materiaali 