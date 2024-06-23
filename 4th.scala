object NotificationExample {
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) => s"You got an email from $sender with title: $title"
      case SMS(caller, message)    => s"You got an SMS from $caller! Message: $message"
    }
  }

  def main(args: Array[String]): Unit = {
    val email = Email("john.doe@example.com", "Meeting Reminder", "Don't forget our meeting at 10 AM")
    val sms = SMS("123-456-7890", "Are you there?")

    println(showNotification(email))
    println(showNotification(sms))
  }
}
