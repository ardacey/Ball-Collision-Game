# Ball Collision Game

A Java command-line puzzle game where a ball moves across a board, interacts with tiles, and accumulates score.

## Features

- Toroidal board movement (wrapping across edges)
- Wall collision response with reverse movement
- Scoring tiles (`R`, `Y`, `B`) and consumed-tile tracking (`X`)
- Hole tile (`H`) that ends the run
- Plain-text input/output for easy testing

## Project Structure

- `src/`: Java source files
- `examples/input/`: sample board and move sequence
- `examples/output/`: expected output generated from the sample input

## Requirements

- Java 8 or newer

## Build

```bash
javac src/*.java
```

## Run

Default output file (`output.txt` in project root):

```bash
java -cp src Main examples/input/board.txt examples/input/move.txt
```

Custom output file:

```bash
java -cp src Main examples/input/board.txt examples/input/move.txt examples/output/output.txt
```

## Input Format

### Board file

- Grid rows separated by new lines
- Cells separated by spaces
- Ball start: `*`
- Wall: `W`
- Hole: `H`
- Score tiles: `R` (+10), `Y` (+5), `B` (-5)
- Other symbols are treated as neutral tiles

### Move file

- Single line of movement commands separated by spaces
- Commands: `L`, `R`, `U`, `D`

## Example

Use the included example input files in `examples/input/` and compare with `examples/output/output.txt`.

## License

This project is available under the MIT License.
