package com.example.jrest.persistance.data

import javax.persistence.*

@Entity
data class Todo(
        @Id @GeneratedValue
        var id: Int? = null,
        var text: String,
        @ManyToMany @JoinTable(
                name = "todos_tags",
                joinColumns = [JoinColumn(name = "todo_id")],
                inverseJoinColumns = [JoinColumn(name = "tag_label")]
        )
        val tags: MutableSet<Tag> = mutableSetOf(),
        @ManyToOne
        val account: Account? = null,
        @Enumerated(EnumType.STRING)
        var status: Status = Status.New
) {
    constructor(label: String, account: Account, vararg tags: Tag) : this(label, account) {
        this.tags.addAll(tags)
    }

    constructor(label: String, account: Account) : this(id = null, text = label, account = account)
    constructor(label: String) : this(null, label)
    constructor() : this(null, "")

    fun done() {
        status = Status.Done
    }

    fun fail() {
        status = Status.Overdue
    }

    fun canBeDone() = status != Status.Done

    fun canBeFailed() = status == Status.New
}
