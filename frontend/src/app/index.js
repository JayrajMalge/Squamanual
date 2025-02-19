function toggleAnswer(questionElement) {
    const answer = questionElement.nextElementSibling;
    const icon = questionElement.querySelector('.toggle-icon');

    if (answer.style.display === "block") {
        answer.style.display = "none";
        icon.textContent = "▶";
    } else {
        answer.style.display = "block";
        icon.textContent = "▼";
    }
}