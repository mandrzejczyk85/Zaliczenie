

 Feature:         Kupowanie Ubrania
   Scenario Outline:      Zakup ubrania oraz weryfikacjia poprawności dokonania zakupu zakończona zrzutem ekranu
     Given        Użytkownik znajduje się na stronie głównej strony zakupowej
     When         Użytkownik klika w opcję Sign In
     And          Użytkownik loguje się do założonego wcześniej konta wpisując email i hasło
     And          Użytkownik klika w zakładkę Clothes w celu przejścia do strony z ubraniami
     And          Użytkownik wybiera odpowiednie ubranie Hummingbird Printed Sweater oraz sprawdza czy znajduje się na nim rabat 20%
     And          Użytkownik wybiera "<rozmiar>" M, ustawia "<ilosc>" na 5 sztuk oraz dodaje zakup do koszyka
     And          Użytkownik potwierdza adres i klika Continue
     And          Użytkownik wybiera metodę dostawy i klika Continue
     And          Użytkownik wybiera metodę płatności Pay by Check, potwierdza regulamin i klika Place Order
     Then         Użytkownik zapisuje zrzut ekranu z potwierdzeniem zamówienia i kwotą
     And          Użytkownik wchodzi w historię zamówień sprawdza czy zamówienie ma status Awaiting check payment oraz czy zgadza się kwota
     And          Zamknięcie przeglądarki

     Examples:
     |rozmiar |ilosc|
     |M       |5    |


