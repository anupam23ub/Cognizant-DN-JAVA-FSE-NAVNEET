package WEEK1.Algorithms_DS.exercise5;

class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId.equals(id)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.taskName);
            current = current.next;
        }
    }

    public void deleteTask(String id) {
        if (head == null) return;

        if (head.task.taskId.equals(id)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.taskId.equals(id)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    public static void main(String[] args) {
        TaskList list = new TaskList();

        list.addTask(new Task("T1", "Setup Database", "Pending"));
        list.addTask(new Task("T2", "Create API", "In Progress"));

        list.traverseTasks();

        Task t = list.searchTask("T2");
        System.out.println(t != null ? t.taskName : "Not Found");

        list.deleteTask("T1");
        list.traverseTasks();
    }
}
