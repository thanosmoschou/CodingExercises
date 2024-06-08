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

node *head; /* Καθολική μεταβλητή που δείχνει πάντα στην αρχή της λίστας. */
node *tail; /* Καθολική μεταβλητή που δείχνει πάντα στον τελευταίο κόμβο της λίστας. */

void add_list_end(const node *p);
void add_list(const node *p, int code);
void show_list(void);
node *find_node(int code);
int del_node(int code);
void free_list(void);

int read_text(char str[], int size, int flag);

int main(void)
{
	int k, sel, code;
	float grd;
	node *p, n;

	head = NULL;
	while (1)
	{
		printf("\nMenu selections\n");
		printf("---------------\n");

		printf("1. Add student at the end\n");
		printf("2. Add student\n");
		printf("3. View all students\n");
		printf("4. View student\n");
		printf("5. Modify student\n");
		printf("6. Delete student\n");
		printf("7. Exit\n");

		printf("\nEnter choice: ");
		scanf("%d", &sel);

		switch (sel)
		{
		case 1:
		case 2: /* Για να αποφύγουμε την επανάληψη του ίδιου κώδικα, η εισαγωγή δεδομένων γίνεται στο ίδιο case. Ανάλογα με την επιλογή του χρήστη, καλείται και η αντίστοιχη συνάρτηση. */
			getchar();

			printf("Name: ");
			read_text(n.name, sizeof(n.name), 1);

			printf("Code: ");
			scanf("%d", &n.code);

			printf("Grade: ");
			scanf("%f", &n.grd);

			if (sel == 1)
				add_list_end(&n);
			else
			{
				printf("\nEnter student code after which the new student will be added: ");
				scanf("%d", &code);
				add_list(&n, code);
			}
			break;

		case 3:
			if (head == NULL)
				printf("\nThe list is empty\n");
			else
				show_list();
			break;

		case 4:
			if (head == NULL)
				printf("\nThe list is empty\n");
			else
			{
				printf("\nEnter student code to search: ");
				scanf("%d", &code);
				p = find_node(code);
				if (p != NULL)
					printf("\nN:%s G:%.2f\n\n", p->name, p->grd);
				else
					printf("\nStudent with code = %d does not exist\n", code);
			}
			break;

		case 5:
			if (head == NULL)
				printf("\nThe list is empty\n");
			else
			{
				printf("\nEnter student code to modify: ");
				scanf("%d", &code);

				printf("Enter new grade: ");
				scanf("%f", &grd);
				p = find_node(code);
				if (p != NULL)
					p->grd = grd;
				else
					printf("\nStudent with code = %d does not exist\n", code);
			}
			break;

		case 6:
			if (head == NULL)
				printf("\nThe list is empty\n");
			else
			{
				printf("\nEnter student code to delete: ");
				scanf("%d", &code);
				k = del_node(code);
				if (k == 0)
					printf("\nStudent with code = %d is deleted\n", code);
				else
					printf("\nStudent with code = %d does not exist\n", code);
			}
			break;

		case 7:
			if (head != NULL)
				free_list();
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}

/* Για την καλύτερη κατανόηση της add_list_end() δείτε τα σχόλια της add_queue() στην προηγούμενη άσκηση. */
void add_list_end(const node *p)
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
		head = tail = new_node;
	else
	{
		tail->next = new_node;
		tail = new_node;
	}
}

void add_list(const node *p, int code)
{
	node *new_node, *ptr;

	ptr = head;
	/* Διατρέχουμε τη λίστα μέχρι να βρούμε τον κόμβο με τον συγκεκριμένο αριθμό μητρώου. Αν βρεθεί, ο νέος κόμβος προστίθεται μετά από αυτόν και η συνάρτηση τερματίζει. */
	while (ptr != NULL)
	{
		if (ptr->code == code)
		{
			new_node = (node*)malloc(sizeof(node));
			if (new_node == NULL)
			{
				printf("Error: Not available memory\n");
				exit(EXIT_FAILURE);
			}
			*new_node = *p; /* Αντιγραφή των στοιχείων του φοιτητή. */
			new_node->next = ptr->next; /* Τώρα, ο νέος κόμβος δείχνει στον κόμβο που δείχνει ο τρέχων κόμβος. */
			ptr->next = new_node; /* Τώρα, ο τρέχων κόμβος δείχνει στον νέο κόμβο, ο οποίος έτσι προστίθεται στη λίστα. */
			if (ptr == tail) /* Ελέγχουμε αν ο νέος κόμβος προστέθηκε στο τέλος της λίστας. Αν ναι, αποτελεί τη νέα ουρά της λίστας. */
				tail = new_node;
			return;
		}
		ptr = ptr->next; /* Ελέγχουμε τον επόμενο κόμβο. */
	}
	/* Αν ο κώδικας φτάσει σε αυτό το σημείο σημαίνει ότι δεν υπάρχει κόμβος στη λίστα που να έχει ίδιο αριθμό μητρώου με αυτό που εισήγαγε ο χρήστης. */
	printf("\nStudent with code = %d does not exist\n", code);
}

void show_list(void)
{
	node *p;

	p = head;
	printf("\n***** Student Data *****\n\n");
	while (p != NULL)
	{
		printf("C:%d N:%s G:%.2f\n\n", p->code, p->name, p->grd);
		p = p->next;
	}
}

node *find_node(int code)
{
	node *p;

	p = head;
	while (p != NULL)
	{
		if (p->code == code)
			return p;
		p = p->next;
	}
	return NULL;
}

int del_node(int code)
{
	node *p, *prev_node; /* Ο δείκτης prev_node θα δείχνει στον προηγούμενο κόμβο από αυτόν που θα διαγράψουμε. */

	p = prev_node = head;
	while (p != NULL)
	{
		if (p->code == code)
		{
			if (p == head)
				head = p->next; /* Αν ο κόμβος είναι η κεφαλή της λίστας, τότε ο επόμενος κόμβος γίνεται η νέα κεφαλή. Αν δεν υπάρχει επόμενος κόμβος, δηλαδή η λίστα περιέχει μόνο την κεφαλή, τότε η τιμή του δείκτη head θα γίνει ίση με NULL. */
			else
			{
				/* Τώρα, ο p δείχνει στον κόμβο που θα διαγραφεί και ο δείκτης prev_node στον προηγούμενο. Η επόμενη εντολή συνδέει τον προηγούμενο κόμβο με τον επόμενο από αυτόν που θα διαγραφεί. */
				prev_node->next = p->next;
				if (p == tail) /* Ελέγχουμε αν ο κόμβος που θα διαγράψουμε είναι η ουρά της λίστας. Αν είναι, ο προηγούμενός του γίνεται η νέα ουρά της λίστας. */
					tail = prev_node;
			}
			free(p); /* Διαγραφή κόμβου. */
			return 0;
		}
		prev_node = p; /* Τώρα, ο prev_node δείχνει στον κόμβο που μόλις ελέγξαμε και διαπιστώσαμε ότι δεν έχει τον επιθυμητό αριθμό μητρώου. */
		p = p->next; /* Τώρα, ο p δείχνει στον επόμενο κόμβο. Σημειώστε ότι ο prev_node δείχνει πάντα στον προηγούμενο κόμβο από αυτόν που ελέγχουμε. */
	}
	return -1;
}

void free_list(void)
{
	node *p, *next_node;

	p = head;
	while (p != NULL)
	{
		next_node = p->next;
		free(p);
		p = next_node;
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