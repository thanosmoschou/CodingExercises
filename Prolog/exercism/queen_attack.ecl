%! create(+DimTuple)
%
% The create/1 predicate succeeds if the DimTuple contains valid chessboard 
% dimensions, e.g. (0,0) or (2,4).
create((DimX, DimY)) :-
	DimX > -1,
    DimX < 8,
    DimY > -1,
    DimY < 8.

%! attack(+FromTuple, +ToTuple)
%
% The attack/2 predicate succeeds if a queen positioned on ToTuple is 
% vulnerable to an attack by another queen positioned on FromTuple.
% Two pawns are on the same diagonal if the absolute difference between 
% their row numbers is equal to the absolute difference between their column numbers.
attack((FromX, FromY), (ToX, ToY)) :-
	FromX =:= ToX;
    FromY =:= ToY;
    same_diagonal((FromX, FromY), (ToX, ToY)).

    
same_diagonal((Row1, Col1), (Row2, Col2)) :-
    abs(Row1 - Row2, RowDiff),
    abs(Col1 - Col2, ColDiff),
    RowDiff =:= ColDiff.

abs(X, Y) :-
    X >= 0,
    Y = X.
    
abs(X, Y) :-
    X < 0,
    Y is -X.