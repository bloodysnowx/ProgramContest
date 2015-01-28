class KnapsackProblemSolver
  def initialize(values, weights, knapsackCapacity)
    @values = values
    @weights = weights
    @knapsackCapacity = knapsackCapacity
    @DPTable = Array.new(values.length + 1){ Array.new(knapsackCapacity + 1, 0) }
  end
  
  def solve()
    (0..(@DPTable.length - 2)).each do |i|
    #@values.each_with_index do |value, i|
      (0..@knapsackCapacity).each do |j|
        @DPTable[i+1][j] = j - @weights[i] >= 0 ?  [@DPTable[i][j], @DPTable[i][j - @weights[i]] + @values[i]].max : @DPTable[i][j]
      end
    end
    return @DPTable.last.last
  end
end

solver = KnapsackProblemSolver.new([3, 2, 4, 2], [2, 1, 3, 2], 5)
p solver.solve()
