# BreakingTheRecords

Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. 
She tabulates the number of times she breaks her season record for most points and least points in a game. 
Points scored in the first game establish her record for the season, and she begins counting from there.

## Example

    scores = [12, 24, 10, 24]
    
    Scores are in the same order as the games played. She tabulates her results as follows:
                                         Count
        Game  Score  Minimum  Maximum   Min Max
         0      12     12       12       0   0
         1      24     12       24       0   1
         2      10     10       24       1   1
         3      24     10       24       1   1

    -> Number of times Maria break her recors for most and least: [2, 2]

## Function Description

**breakingRecords** has the following parameter(s):

* int scores[n]: points scored per game

## Returns

* int[2]: An array with the numbers of times she broke her records. 
Index _0_ is for breaking most points records, and index _1_ is for breaking least points records.