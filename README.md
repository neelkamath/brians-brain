# Brian's Brain

This is an implementation of the [Brian's Brain](https://en.wikipedia.org/wiki/Brian%27s_Brain) cellular automaton.

## Installation

1. Install [Kotlin 1.3](https://kotlinlang.org/docs/tutorials/command-line.html#downloading-the-compiler).
1. Clone the repository using one of the following methods.
    - SSH: `git clone git@github.com:neelkamath/brians-brain.git`
    - HTTPS: `git clone https://github.com/neelkamath/brians-brain.git`

## Usage

1. `cd brians-brain`
1. `<GRADLE> --args="<ROWS> <COLUMNS> <STEPS>"`, where `<GRADLE>` is `gradle.bat` if you're on Windows, and `./gradlew` on *nix, `<ROWS>` and `<COLUMNS>` are the number of rows and columns in the grid, and `<STEPS>` are the number of time steps to generate.

The program will print `0`, `1`, and `2`s indicating "off", "dying", and "on" cells respectively.

## License

This project is under the [MIT License](LICENSE).