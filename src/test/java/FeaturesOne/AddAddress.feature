
  Feature:              Weryfikacja Poprawności
    Scenario Outline:   Dodanie adresu, sprawdzenie poprawności wprowadzonych danych oraz usunięcie adresu
      Given             Użytkownik znajduje się na stronie głównej
      When              Użytkownik wybiera opcję Sign In
      And               Użytkownik wpisuje prawidłowy email i haslo a następnie zatwierdza dane poprzez wybranie przycisku zalogowania
      And               Użytkownik klika w pole ADDRESS na stronie Your Account
      And               Użytkwonik klika w pole Create new address na stronie Your addresses
      And               Użytkownik uzupełnia formularz danymi "<alias>", "<address>", "<city>", "<zipPostalCode>", "<country>", "<phone>"
      Then              Użytkownik zostaje przeniesiony na stronę z dodanym adresem i sprawdza poprawność danych
      And               Użytkownik usuwa dodany adres i sprawdza poprawność jego usunięcia
      And               Zamykanie przeglądarki


      Examples:
        |alias        |address  |city     |zipPostalCode  |country         |phone    |
        |Adres Domowy |Prosta 51|Warszawa |00-839         |United Kingdom  |501234567|