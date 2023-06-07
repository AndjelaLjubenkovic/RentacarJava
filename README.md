# Rent-a-Car Java Desktop aplikacija
Rent-a-Car Java Desktop aplikacija je aplikacija za iznajmljivanjem automobila. 
Omogućava korisnicima da pregledaju dostupne automobile i kreiraju rezervaciju za željeni automobil.

## Arhitektura
Aplikacija je implementirana koristeći arhitekturu Model-View-Controller (MVC).

* Model sloj sadrži klase koje predstavljaju entitete u bazi podataka, kao što su Auto, Klijent i Rezervacija. Ove klase sadrže logiku za pristup i upravljanje podacima.
* View sloj je odgovoran za prikazivanje korisničkog interfejsa i interakciju sa korisnikom. Koristi se Java Swing biblioteka za izradu grafičkog korisničkog interfejsa.
* Controller sloj deluje kao posrednik između Modela i View-a. Obrada korisničkih zahteva i upravljanje logikom aplikacije obavljaju se u ovom sloju.

## Tehnologije i alati
* Java
* Java Swing
* MySQL
* JDBC (Java Database Connectivity)

## Pokretanje aplikacije
* Klonirajte ovaj repozitorijum na svoj lokalni sistem.
* Importujte projekat u odgovarajući Java razvojni okvir (npr. Eclipse, IntelliJ IDEA).
* Konfigurišite MySQL bazu podataka sa podacima iz priloženog SQL dump fajla.
* Ažurirajte konfiguracioni fajl aplikacije (config.properties) sa odgovarajućim podacima za konekciju na bazu podataka.
* Izvršite aplikaciju pokretanjem glavne klase Main.java.

## Testiranje
Testiranje aplikacije je izvršeno pomoću DBUnit biblioteke za testiranje baze podataka.

Da biste pokrenuli testove:

* Konfigurišite test bazu podataka sa odgovarajućim podacima.
* Izvršite test klase koje se nalaze u test direktorijumu.

## Dalji razvoj 
Za dalji razvoj aplikacije planiran je razvoj admin panela putem kojeg će admin imati mogućnosti:
* Krweiranje auta
* 
## Autori
Aplikacija je razvijena od strane:
- Dušan Glišić [@DusanSistem](https://github.com/DusanSistem)
- Andjela Ljubenković [@Andjelaljubenkovic](https://github.com/AndjelaLjubenkovic)
- Mark Johnson [@markjohnson](https://github.com/markjohnson)
