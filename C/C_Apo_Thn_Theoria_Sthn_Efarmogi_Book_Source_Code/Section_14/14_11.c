#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node
{
	char name[100];
	int code;
	float grd;
	struct node *next; /* ������� ���� ������� ����� ��� �������. ����� �� ����������� ��� ��������, ���� �� �������� �� ��������� ��� ���� ��� ������. */
} node;

node *head; /* �������� ��������� ��� ������� ����� ���� ������ ��� �������. */

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

	head = NULL; /* ������ ���� ���� ������ head, � ����� ������� ��� � ������ ����� �����. */
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

	/* �������� ������ ��� �� ���������� ��� ���� ������. */
	new_node = (node*)malloc(sizeof(node));
	if (new_node == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	*new_node = *p; 	/* ��������� ��� ��������� ��� ������� ���� ��� �����. */
	new_node->next = head; /* � ���� ������ ��������� ���� ���� ��� ������� ���� ��� ������ next. ��� ����������, ��� ����� ���� ��� ��������� ���� �������� � ���� ��� new_node->next ������� ��� �� ��� ������ ���� ��� head ��� ����� NULL. */
	head = new_node; /* � ���� ������ ������� � ��� ������ ��� �������. */
}

void show_stack(void)
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

int size_stack(void)
{
	node *p;
	int num;

	num = 0;
	p = head;
	while (p != NULL)
	{
		p = p->next;
		num++; /* ���� � ��������� ������� ���� �������, ����� �� �������� ���� ��������� ����� ��� �������. */
	}
	return num;
}

void free_stack(void)
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