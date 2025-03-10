% Define the 'chatty' fact
chatty(gustavo).
chatty(valeria).

% Define the 'likes' fact
likes(esteban, malena).
likes(malena, esteban).
likes(gustavo, valeria).

% Define the 'pairing' rule
pairing(Person1, Person2) :- 
    likes(Person1, Person2), 
    likes(Person2, Person1).

pairing(Person1, Person2) :- 
    chatty(Person1); 
    chatty(Person2).

% Define the 'seating' rule
seating(P1, P2, P3, P4, P5) :- 
    pairing(P1, P2),
    pairing(P2, P3),
    pairing(P3, P4),
    pairing(P4, P5).