### Usage
In order to start program you need to type `java -jar ....jar`. To start the program in the debugging mode you need to add `--logLevel debug` flag, so the line would be `java -jar ....jar --logLevel debug`.

At the start of the application you will be offered to enter matrix dimension and then matrices themselves. Thereafter, the algorithm will output the answer.

### Algorithm
This program implements Four Russians algorithm for boolean matrix multiplication.

The algorithm consists of two main steps:
1. Preprocessing matrices
2. Multiplying them. (Main part of the algo)

**In the first step** we divide matrices by [n/log(n)] (rounds up), the A matrix column-wise and the B matrix row-wise.
So, A matrix will be n x [log(n)] and B matrix will be [log(n)] x n (these two rounds down).
If n is not divided by log(n), we pad the last part of A with zero columns and the last part of B with zero rows.

In the second step (multiply method, after preprocessing call) we multiply parts obtained from the previous step according to the algorithm.
All details of the algorithm you can get from [here](https://louridas.github.io/rwa/assignments/four-russians/).
