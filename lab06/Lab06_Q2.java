package lab06;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Q2 {

    static Scanner input = new Scanner(System.in);

    static String[] songTitles;
    static int[] ratings;
    static ArrayList<String> titleList;
    static ArrayList<Integer> ratingList;

    static int count = 0;
    static boolean usingArrayList = false;

    public static void addSong(String title, int rating) {
        if (title.trim().length() == 0) {
            System.out.println("Song title cannot be empty!");
            return;
        }

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5!");
            return;
        }

        if (usingArrayList) {
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equalsIgnoreCase(title)) {
                    System.out.println("Song already exists!");
                    return;
                }
            }

            titleList.add(title);
            ratingList.add(rating);
            System.out.println("Song added successfully!");
        } else {
            for (int i = 0; i < count; i++) {
                if (songTitles[i].equalsIgnoreCase(title)) {
                    System.out.println("Song already exists!");
                    return;
                }
            }

            if (count < songTitles.length) {
                songTitles[count] = title;
                ratings[count] = rating;
                count++;
                System.out.println("Song added successfully!");
            } else {
                System.out.println("Array full! Switching to dynamic ArrayList...");

                titleList = new ArrayList<String>();
                ratingList = new ArrayList<Integer>();

                for (int i = 0; i < count; i++) {
                    titleList.add(songTitles[i]);
                    ratingList.add(ratings[i]);
                }

                usingArrayList = true;

                titleList.add(title);
                ratingList.add(rating);
                System.out.println("Song added successfully!");
            }
        }
    }

    public static void removeSong(String title) {
        if (usingArrayList) {
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equalsIgnoreCase(title)) {
                    titleList.remove(i);
                    ratingList.remove(i);
                    System.out.println("Song removed.");
                    return;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (songTitles[i].equalsIgnoreCase(title)) {
                    for (int j = i; j < count - 1; j++) {
                        songTitles[j] = songTitles[j + 1];
                        ratings[j] = ratings[j + 1];
                    }

                    songTitles[count - 1] = null;
                    ratings[count - 1] = 0;
                    count--;

                    System.out.println("Song removed.");
                    return;
                }
            }
        }

        System.out.println("Song not found!");
    }

    public static void updateSongRating(String title, int newRating) {
        if (usingArrayList) {
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equalsIgnoreCase(title)) {
                    int currentRating = ratingList.get(i);
                    System.out.println("Current rating: " + currentRating);

                    while (newRating < 1 || newRating > 5 || newRating == currentRating) {
                        if (newRating == currentRating) {
                            System.out.println("New rating cannot be the same as the current rating. Try again.");
                        } else {
                            System.out.println("Rating must be between 1 and 5!");
                        }

                        System.out.print("Enter new rating (1-5): ");
                        newRating = input.nextInt();
                    }

                    ratingList.set(i, newRating);
                    System.out.println("Rating updated.");
                    return;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (songTitles[i].equalsIgnoreCase(title)) {
                    int currentRating = ratings[i];
                    System.out.println("Current rating: " + currentRating);

                    while (newRating < 1 || newRating > 5 || newRating == currentRating) {
                        if (newRating == currentRating) {
                            System.out.println("New rating cannot be the same as the current rating. Try again.");
                        } else {
                            System.out.println("Rating must be between 1 and 5!");
                        }

                        System.out.print("Enter new rating (1-5): ");
                        newRating = input.nextInt();
                    }

                    ratings[i] = newRating;
                    System.out.println("Rating updated.");
                    return;
                }
            }
        }

        System.out.println("Song not found!");
    }

    public static void searchSong(String title) {
        if (usingArrayList) {
            for (int i = 0; i < titleList.size(); i++) {
                if (titleList.get(i).equalsIgnoreCase(title)) {
                    System.out.println(titleList.get(i) + " has rating " + ratingList.get(i));
                    return;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (songTitles[i].equalsIgnoreCase(title)) {
                    System.out.println(songTitles[i] + " has rating " + ratings[i]);
                    return;
                }
            }
        }

        System.out.println("Song not found!");
    }

    public static void viewAllSongs() {
        if (usingArrayList) {
            if (titleList.size() == 0) {
                System.out.println("Playlist is empty.");
                return;
            }

            System.out.println("Playlist:");
            for (int i = 0; i < titleList.size(); i++) {
                System.out.println((i + 1) + ". " + titleList.get(i) + " (Rating: " + ratingList.get(i) + ")");
            }
        } else {
            if (count == 0) {
                System.out.println("Playlist is empty.");
                return;
            }

            System.out.println("Playlist:");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + songTitles[i] + " (Rating: " + ratings[i] + ")");
            }
        }
    }

    public static void exit() {
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        System.out.print("Enter initial playlist capacity: ");
        int capacity = input.nextInt();
        input.nextLine();

        songTitles = new String[capacity];
        ratings = new int[capacity];

        int choice;

        do {
            System.out.println("=== Playlist Manager ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Update Song Rating");
            System.out.println("4. Search Song");
            System.out.println("5. View All Songs");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter song title: ");
                String title = input.nextLine();

                System.out.print("Enter rating (1-5): ");
                int rating = input.nextInt();
                input.nextLine();

                addSong(title, rating);
            } else if (choice == 2) {
                System.out.print("Enter song title to remove: ");
                String title = input.nextLine();
                removeSong(title);
            } else if (choice == 3) {
                System.out.print("Enter song title to update: ");
                String title = input.nextLine();

                System.out.print("Enter new rating (1-5): ");
                int newRating = input.nextInt();
                input.nextLine();

                updateSongRating(title, newRating);
            } else if (choice == 4) {
                System.out.print("Enter song title to search: ");
                String title = input.nextLine();
                searchSong(title);
            } else if (choice == 5) {
                viewAllSongs();
            } else if (choice == 6) {
                exit();
            } else {
                System.out.println("Invalid option!");
            }

        } while (choice != 6);

        input.close();
    }
}