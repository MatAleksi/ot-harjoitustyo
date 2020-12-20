# Käyttöohje

Lataa tiedosto [CasinoGame-1.0-SNAPSHOT.jar](https://github.com/MatAleksi/ot-harjoitustyo/releases/download/1.0/CasinoGame-1.0-SNAPSHOT.jar)

Sovellus käynnistyy komennolla java -jar CasinoGame-1.0-SNAPSHOT.jar

## Päävalikko 

Päävalikossa käyttäjä näkee rahamääränsä, ja pystyy siirtymään joko rulettiin tai blackjackkiin.

## Ruletti

Rulettinäkymässä käyttäjä voi liukusäätimen avulla valita panoksen määrän, ja mitä tahansa panostus painikkeista painamalla lisätä panoksen valitsemalleen veikkaukselle. Kun käyttäjä on asettanut haluamansa määrän panoksia, nappia spin painamalla sovellus arpoo luvun, ja maksaa pelaajalle panokset jotka voittavat. Oikean numeron arvaava panos voittaa 35-kertaisen summan, muut veikkaukset voittavat 2-kertaisen summan. Käyttäjä voi palata pää valikkoon "Main menu" nappia painamalla.

## Blackjack

Blackjacknäkymässä käyttäjä valitsee liukusäätimellä haluamansa panoksen ja painaa deal. Pelaaja pyrkii saamaan kätensä mahdollisimman lähelle kahtakymmentäyhtä ylittämättä sitä. Jos pelaajan käsi on pelin lopussa suurempi kuin jakajan ylittämättä kahtakymmentäyhtä, käyttäjä voittaa panoksen kaksinkertaisena. Jos käyttäjä saa blackjackin eli 21 kahdella kortilla, hän voittaa panoksen kolminkertaisena. Pelin aikana käyttäjä voi pyytää lisää kortteja tai jäädä. Pelaaja voi tuplata panoksensa, jolloin hän ottaa yhden kortin mutta ei voi ottaa enempää. Jakaja joutuu aina nostamaan 16 asti ja joutuu lopettamaan nostamisen 17. Ässä eli 1 on myös 11. 

