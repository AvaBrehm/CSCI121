public class Party {
    private int numberOfGuests;

    public void setNumberOfGuests(int guests) {
        numberOfGuests = guests;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void displayInvitation() {
        System.out.println("✨ Get ready to have a blast at the party! ✨ ");
    }
}

