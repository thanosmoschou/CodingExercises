#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node
{
	char name[100];
	int code;
	float grd;
	struct node *next; /* Δείκτης στον επόμενο κόμβο της στοίβας. Δείτε τη χρησιμότητα της ετικέτας, ώστε να μπορούμε να δηλώσουμε τον τύπο του δείκτη. */
} node;

node *head; /* Καθολική μεταβλητή που δείχνει πάντα στην κεφαλή της στοίβας. */

void add_stack(const node *p);
void show_stack(void);
void pop(void);
int size_stack(void);
void free_stack(void);

int read_text(char str[], int size, int flag);

int main(void)
{
	int sel;
	node n;

	head = NULL; /* Αρχική τιμή στον δείκτη head, η οποία δηλώνει ότι η στοίβα είναι άδεια. */
	while (1)
	{
		printf("\nMenu selections\n");
		printf("---------------\n");

		printf("1. Add student\n");
		printf("2. View all students\n");
		printf("3. View top student\n");
		printf("4. Delete top student\n");
		printf("5. Number of students\n");
		printf("6. Exit\n");

		printf("\nEnter choice: ");
		scanf("%d", &sel);

		switch (sel)
		{
		case 1:
			getchar();

			printf("Name: ");
			read_text(n.name, sizeof(n.name), 1);

			printf("Code: ");
			scanf("%d", &n.code);
			printf("Grade: ");
			scanf("%f", &n.grd);

			add_stack(&n);
			break;

		case 2:
			if (head != NULL)
				show_stack();
			else
				printf("\nThe stack is empty\n");
			break;

		case 3:
			if (head != NULL)
				printf("\nC:%d N:%s G:%.2f\n\n",
				head->code, head->name, head->grd);
			else
				printf("\nThe stack is empty\n");
			break;

		case 4:
			if (head != NULL)
				pop();
			else
				printf("\nThe stack is empty\n");
			break;

		case 5:
			if (head != NULL)
				printf("\n%d students exist in stack\n", size_stack());
			else
				printf("\nThe stack is empty\n");
			break;

		case 6:
			if (head != NULL)
				free_stack();
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}



void add_stack(const node *p)
{
	node *new_node;

	/* Δέσμευση μνήμης για τη δημιουργία του νέου κόμβου. */
	new_node = (node*)malloc(sizeof(node));
	if (new_node == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	*new_node = *p; 	/* Αντιγραφή των στοιχείων του φοιτητή στον νέο κόμβο. */
	new_node->next = head; /* Ο νέος κόμβος εισάγεται στην αρχή της στοίβας μέσω του δείκτη next. Για παράδειγμα, την πρώτη φορά που εισάγεται ένας φοιτητής η τιμή του new_node->next γίνεται ίση με την αρχική τιμή του head που είναι NULL. */
	head = new_node; /* Ο νέος κόμβος γίνεται η νέα κεφαλή της στοίβας. */
}

void show_stack(void)
{
	node *p;

	p = head;
	printf("\n***** Student Data *****\n\n");
	while (p != NULL)
	{
		printf("C:%d N:%s G:%.2f\n\n", p->code, p->name, p->grd);
		p = p->next; /* Σε κάθε επανάληψη, ο p δείχνει στον επόμενο κόμβο. Όταν η τιμή του γίνει ίση με NULL σημαίνει ότι δεν υπάρχει άλλος κόμβος και ο βρόχος τερματίζεται. */
	}
}

void pop(void)
{
	node *p;
	p = head->next; /* Ο p δείχνει στον επόμενο κόμβο της στοίβας. Αυτός ο κόμβος θα γίνει η νέα κεφαλή. */
	printf("\nStudent with code =%d is deleted\n", head->code);
	free(head); /* Αποδέσμευση μνήμης. Η πληροφορία για το ποιος είναι ο επόμενος κόμβος δεν χάθηκε, γιατί αποθηκεύτηκε προηγουμένως στον δείκτη p. */
	head = p; /* Τώρα, ο head δείχνει στη νέα κεφαλή της στοίβας. */
}

int size_stack(void)
{
	node *p;
	int num;

	num = 0;
	p = head;
	while (p != NULL)
	{
		p = p->next;
		num++; /* Αυτή η μεταβλητή μετράει τους κόμβους, μέχρι να φτάσουμε στον τελευταίο κόμβο της στοίβας. */
	}
	return num;
}

void free_stack(void)
{
	node *p, *next_node;

	p = head;
	while (p != NULL)
	{
		next_node = p->next; /* Ο next_node δείχνει στον κόμβο που είναι μετά από αυτόν που θα διαγραφεί. */
		free(p); /* Αποδέσμευση μνήμης. Η πληροφορία για το ποιος είναι ο επόμενος κόμβος δεν χάθηκε, γιατί αποθηκεύτηκε προηγουμένως στον δείκτη next_node. */
		p = next_node; /* Τώρα, ο p δείχνει στον επόμενο κόμβο. */
	}
}

int read_text(char str[], int size, int flag)
{
	int len;

	if (fgets(str, size, stdin) == NULL)
	{
		printf("Error: fgets() failed\n");
		exit(EXIT_FAILURE);
	}
	len = strlen(str);
	if (len > 0)
	{
		if (flag && (str[len - 1] == '\n'))
		{
			str[len - 1] = '\0';
			len--;
		}
	}
	else
	{
		printf("Error: No input\n");
		exit(EXIT_FAILURE);
	}
	return len;
}