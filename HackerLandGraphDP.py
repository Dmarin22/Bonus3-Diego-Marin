import matplotlib.pyplot as plt

sizes = []
times = []

with open('/Users/diegomarin/Desktop/Bonus 3/time_measurementsDP.csv', 'r') as file:
    for line in file:
        size, time = line.strip().split(',')
        sizes.append(int(size))
        times.append(int(time))

plt.plot(sizes, times, marker='o')
plt.xlabel('Input Size')
plt.ylabel('Execution Time (nanoseconds)')
plt.title('Time Complexity of Modified Hackerland Radio Transmitters')
plt.show()

