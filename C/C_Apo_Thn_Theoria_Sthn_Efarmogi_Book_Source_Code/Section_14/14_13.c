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

node *head; /* �������� ��������� ��� ������� ����� ���� ���� ��� ������. */
node *tail; /* �������� ��������� ��� ������� ����� ���� ��������� ����� ��� ������. */

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
		case 2: /* ��� �� ���������� ��� ��������� ��� ����� ������, � �������� ��������� ������� ��� ���� case. ������� �� ��� ������� ��� ������, �������� ��� � ���������� ���������. */
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

/* ��� ��� �������� ��������� ��� add_list_end() ����� �� ������ ��� add_queue() ���� ����������� ������. */
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
	/* ����������� �� ����� ����� �� ������ ��� ����� �� ��� ������������ ������ �������. �� ������, � ���� ������ ����������� ���� ��� ����� ��� � ��������� ����������. */
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
			*new_node = *p; /* ��������� ��� ��������� ��� �������. */
			new_node->next = ptr->next; /* ����, � ���� ������ ������� ���� ����� ��� ������� � ������ ������. */
			ptr->next = new_node; /* ����, � ������ ������ ������� ���� ��� �����, � ������ ���� ����������� ��� �����. */
			if (ptr == tail) /* ��������� �� � ���� ������ ���������� ��� ����� ��� ������. �� ���, �������� �� ��� ���� ��� ������. */
				tail = new_node;
			return;
		}
		ptr = ptr->next; /* ��������� ��� ������� �����. */
	}
	/* �� � ������� ������ �� ���� �� ������ �������� ��� ��� ������� ������ ��� ����� ��� �� ���� ���� ������ ������� �� ���� ��� �������� � �������. */
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
	node *p, *prev_node; /* � ������� prev_node �� ������� ���� ����������� ����� ��� ����� ��� �� �����������. */

	p = prev_node = head;
	while (p != NULL)
	{
		if (p->code == code)
		{
			if (p == head)
				head = p->next; /* �� � ������ ����� � ������ ��� ������, ���� � �������� ������ ������� � ��� ������. �� ��� ������� �������� ������, ������ � ����� �������� ���� ��� ������, ���� � ���� ��� ������ head �� ����� ��� �� NULL. */
			else
			{
				/* ����, � p ������� ���� ����� ��� �� ��������� ��� � ������� prev_node ���� �����������. � ������� ������ ������� ��� ����������� ����� �� ��� ������� ��� ����� ��� �� ���������. */
				prev_node->next = p->next;
				if (p == tail) /* ��������� �� � ������ ��� �� ����������� ����� � ���� ��� ������. �� �����, � ������������ ��� ������� � ��� ���� ��� ������. */
					tail = prev_node;
			}
			free(p); /* �������� ������. */
			return 0;
		}
		prev_node = p; /* ����, � prev_node ������� ���� ����� ��� ����� �������� ��� ������������ ��� ��� ���� ��� ��������� ������ �������. */
		p = p->next; /* ����, � p ������� ���� ������� �����. ��������� ��� � prev_node ������� ����� ���� ����������� ����� ��� ����� ��� ���������. */
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