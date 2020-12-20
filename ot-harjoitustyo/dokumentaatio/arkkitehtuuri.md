# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraavanlainen. 

<img src="https://github.com/MatAleksi/ot-harjoitustyo/blob/main/ot-harjoitustyo/dokumentaatio/kuvat/rakenne.PNG" width="600">

Pakkaus CasinoGame.ui sisältää käyttöliittymän joka toimii javaFX:llä. CasinoGame.blackjack ja CasinoGame.roulette sisältävät blackjackin ja ruletin sovelluslogiikat. CasinoGame.player sisältää pelaajaan liittyvät metodit, joita ui, blackjack, ja ruletti käyttävät.

## Käyttöliittymä

Käyttöliittymässä on kolme erilaista näkymää. Kun sovellus käynnistetään aukeaa päävalikko, jossa käyttäjä näkee rahansa ja voi siirtyä joko blackjack- tai rulettinäkymään. Blackjacknäkymässä käyttäjä voi pelata blackjackia. Rulettinäkymässä käyttäjä voi pelata rulettia.

## Sovelluslogiikka

<img src ="https://github.com/MatAleksi/ot-harjoitustyo/blob/main/ot-harjoitustyo/dokumentaatio/kuvat/Luokkakaavio.PNG" width="600">

Sovelluksessa UserInterfacella on Player jonka avulla Userinterfacelle luodaan myös Roulette luokka, ja BlackJack ja BlackjackGame luokat. Pelien sisällä tapahtuva logiikka tapahtuu luokissa Roulette, BlackJack ja BlackjackGame. UserinterFace saa näistä luokista tietoja, jotka näytetään käyttöliittymässä pelien edetessä.

## Tietojen pysyväistallennus

Sovelluksessa ei ole tietojen pysyväistallennusta. Aina kun sovelluksen käynnistää se luo uuden pelaajan. 

## Ohjelmaan jääneet heikkoudet

Sovellukseen olisi voinut tehdä enemmän pelejä. Käyttöliittymä jäi melko yksinkertaiseksi. Ohjelmaan olisi voinut luoda joko tallenustoimivuuden tai hiscore toimivuuden jotka olisivat voinet olla pysyväistallennuksessa.
