#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node
{
	char name[100];
	int code;
	float grd;
	struct node *next;
} node;

node *head; /* Καθολική μεταβλητή που δείχνει πάντα στην αρχή της ουράς. */
node *tail; /* Καθολική μεταβλητή που δείχνει πάντα στον τελευταίο κόμβο της ουράς. */

void add_queue(const node *p);
void show_queue(void);
void pop(void);
void free_queue(void);

int read_text(char str[], int size, int flag);

int main(void)
{
	int sel;
	node n;

	head = NULL;
	while (1)
	{
		printf("\nMenu selections\n");
		printf("---------------\n");
		printf("1. Add student\n");
		printf("2. View all students\n");
		printf("3. View last student\n");
		printf("4. Delete top student\n");
		printf("5. Exit\n");
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

			add_queue(&n);
			break;

		case 2:
			if (head != NULL)
				show_queue();
			else
				printf("\nThe queue is empty\n");
			break;

		case 3:
			if (head != NULL)
				printf("\nC:%d N:%s G:%.2f\n\n",
				tail->code, tail->name, tail->grd);
			else
				printf("\nThe queue is empty\n");
			break;

		case 4:
			if (head != NULL)
				pop();
			else
				printf("\nThe queue is empty\n");
			break;

		case 5:
			if (head != NULL)
				free_queue();
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}

void add_queue(const node *p)
{
	node *new_node;

	new_node = (node*)malloc(sizeof(node));
	if (new_node == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	*new_node = *p;
	new_node->next = NULL;

	if (head == NULL)
		head = tail = new_node; /* Αν η ουρά είναι άδεια, οι δείκτες head και tail θα δείχνουν στον νέο κόμβο. */
	else
	{
		tail->next = new_node; /* Ο νέος κόμβος εισάγεται στο τέλος της ουράς μέσω του δείκτη next. */
		tail = new_node; /* Τώρα, ο δείκτης tail δείχνει στον νέο τελευταίο κόμβο. */
	}
}


void show_queue(void)
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

void free_queue(void)
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