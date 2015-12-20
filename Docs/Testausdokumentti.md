# Testausdokumentti

Testaamiseen on k‰ytetty JUnit-testej‰ ja lis‰ksi ohjelman suorituksen kautta pystyy tekem‰‰n suorituskykytestausta. Tyˆss‰ olisi voinut k‰ytt‰‰ enemm‰n test-driven development -tyylist‰ etenemist‰, mik‰ olisi auttanut helpottamaan bugien selvitt‰mist‰.

JUnit-testit:

Astar
- searchKeko()
- searchPriorityQueue()

Keko
- add(Solmu solmu)
- isEmpty()
- poll()
- contains(Solmu solmu)
- getLength()
- getSolmuIndex(int i)

Labyrintti
- getSolmu(int x, int y)
- getStart()
- getGoal()
- getNeighbours2(Solmu solmu)
- dist_between(Solmu current, Solmu neighbour)

Pino
- push(Solmu solmu)
- pop() 
- empty()
- contains(Solmu solmu)

Solmu
- getX()
- getY()
- toString()
- isObstacle()
- set_g_score(int i)
- get_g_score()
- set_f_score(int i)
- get_f_score()
- compareTo(Solmu solmu)
- setPrevious(Solmu solmu)
- getPrevious()
- setIndex(int i)
- getIndex()

# Suorituskykytestaus

Suorituskykytestausta on toteutettu p‰‰ohjelmassa, jossa voi vertailla A* aikavaatimuksia omien tietorakenteiden ja Javan valmiiden v‰lill‰. Merkitt‰v‰‰ eroa ei tunnu olevan suorituksen viem‰ss‰ ajassa.