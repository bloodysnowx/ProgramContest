class FibonacciCalculator
  def initialize
    @fibonacciCash = Hash.new
    @fibonacciCash.default_proc = -> (hash, key) { hash[key] = calc(key) }
  end

  def calc(number)
    return number < 2 ? number : @fibonacciCash[number - 1] + @fibonacciCash[number - 2]
  end
end

class FibonacciCalculator2
  def initialize
    @fibonacciCash = Hash.new do |hash, n|
      hash[n] = n < 2 ? n : hash[n - 1] + hash[n - 2]
    end
  end

  def calc(number)
    return @fibonacciCash[number]
  end
end

calculator = FibonacciCalculator.new
puts calculator.calc(ARGV[0].to_i)
calculator = FibonacciCalculator2.new
puts calculator.calc(ARGV[0].to_i)

fibonacci = Hash.new do |h, n|
  h[n] = n < 2 ? n : h[n - 1] + h[n - 2]
end
