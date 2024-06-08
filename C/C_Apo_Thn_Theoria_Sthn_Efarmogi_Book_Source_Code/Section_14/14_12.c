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

node *head; /* �������� ��������� ��� ������� ����� ���� ���� ��� �����. */
node *tail; /* �������� ��������� ��� ������� ����� ���� ��������� ����� ��� �����. */

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
		head = tail = new_node; /* �� � ���� ����� �����, �� ������� head ��� tail �� �������� ���� ��� �����. */
	else
	{
		tail->next = new_node; /* � ���� ������ ��������� ��� ����� ��� ����� ���� ��� ������ next. */
		tail = new_node; /* ����, � ������� tail ������� ���� ��� ��������� �����. */
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
		p = p->next; /* �� ���� ���������, � p ������� ���� ������� �����. ���� � ���� ��� ����� ��� �� NULL �������� ��� ��� ������� ����� ������ ��� � ������ ������������. */
	}
}

void pop(void)
{
	node *p;
	p = head->next; /* � p ������� ���� ������� ����� ��� �������. ����� � ������ �� ����� � ��� ������. */
	printf("\nStudent with code =%d is deleted\n", head->code);
	free(head); /* ����������� ������. � ���������� ��� �� ����� ����� � �������� ������ ��� ������, ����� ������������ ������������ ���� ������ p. */
	head = p; /* ����, � head ������� ��� ��� ������ ��� �������. */
}

void free_queue(void)
{
	node *p, *next_node;

	p = head;
	while (p != NULL)
	{
		next_node = p->next; /* � next_node ������� ���� ����� ��� ����� ���� ��� ����� ��� �� ���������. */
		free(p); /* ����������� ������. � ���������� ��� �� ����� ����� � �������� ������ ��� ������, ����� ������������ ������������ ���� ������ next_node. */
		p = next_node; /* ����, � p ������� ���� ������� �����. */
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