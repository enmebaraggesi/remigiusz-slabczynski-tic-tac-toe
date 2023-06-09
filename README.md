# tic-tac-toe

Celem projektu jest gra w tradycyjne Kółko i Krzyżyk na planszy 3 × 3.
W grze będzie możliwy wybór pomiędzy rozgrywką na dwóch graczy bądź wariant solo przeciwko graczowi CPU.
Gracze będą mieli możliwość określenia liczby rozgrywek, których chcą się podjąć.
Poza tym dostępna będzie opcja zapisu stanu gry i jej opuszczenie 
lub wczytania uprzednio zapisanego stanu gry i jej kontynuacji.

Założenia projektu:
- w grę można grać we dwóch graczy
- w grę można grać z CPU zamiast drugiego gracza
- gra powinna posiadać interfejs obsługiwany przez klawiaturę
- gra musi zapobiegać niedozwolonym ruchom
- gra powinna oferować jakościowe SI gracza komputera
- wobec powyższego ruchy komputera powinny zmierzać do wygranej bądź zablokowania gracza
- powinna istnieć możliwość zapisania obecnego stanu rozgrywki
- przy powyższym założeniu, gra powinna umożliwić wczytanie poprzedniej rozgrywki i jej kontynuację

Zasady rozgrywki:
- w grze bierze udział dwóch graczy przeciwko sobie lub jeden gracz przeciw komputerowi
- planszą do gry jest tabela składająca się z 9 pól, po 3 kolumny w 3 linijkach
- do dyspozycji graczy są dwie figury reprezentowane przez "O" lub "X"
- ruch graczy polega na wyborze pola planszy i umieszczenie na nim swojej figury
    - gracz musi wybrać jakieś pole i umieścić na nim swoją figurę
    - gracz podczas swojej tury może wybrać tylko jedno pole
    - wybrane pole musi być niezajęte przez żadną z figur
- celem każdego z graczy jest ustawienie w jednej linii trzech swoich figur
    - punktowane linie są liniami prostymi w pozycji ortogonalnej lub diagonalnej

Przebieg rozgrywki:
- gracze są informowani o zasadach rozgrywki
- gracze mają możliwość wczytania zapisu gry
- gracze ustalają swoje imiona/nicki (gracz X i gracz O) oraz liczbę gier do rozegrania
- losowo jest ustalany pierwszy gracz
- pierwszy gracz musi podjąć decyzję gdzie umieścić swoją pierwszą figurę
- po nim następuje kolejka drugiego gracza, który musi umieścić swoją figurę
- gra dobiega końca kiedy:
    - jeden z graczy umieścił trzy figury w linii — WYGRANA
    - nie jest dostępne żadne wolne pole planszy — REMIS