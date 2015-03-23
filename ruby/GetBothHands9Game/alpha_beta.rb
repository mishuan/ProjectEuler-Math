require 'set'

class AlphaBeta

  def initialize
    @state_set = Set.new
  end

  def solve(state, player)
    @state_set << state
    next_states = successor_states(state, player)
    scores = []

    print "next_states = #{next_states} \n"
    
    if goal_state?(state)
      return score(state)
    end
    
    for s in next_states
      rearrage_state(s)
      unless checked? s
        scores << solve(s, (player + 1) % 2)
      end
    end

    print "state = #{state}, scores = #{scores} \n"

    if scores.any?    
      if player == 0
        return scores.max
      elsif player == 1
        return scores.min
      end
    else
      return 0
    end
  end

  def goal_state?(state)
    if state[0] == 9 && state[1] == 9
      true
    elsif state[2] == 9 && state[3] == 9
      true
    else
      false
    end
  end

  def checked?(state)
    @state_set.include? state
  end

  def score(state)
    if state[0] == 9 && state[1] == 9
      1
    elsif state[2] == 9 && state[3] == 9
      -1
    end
  end

  def successor_states(state, player)
    next_states = []
    if player == 0
      next_states << [(state[0] + state[2]) % 10, state[1], state[2], state[3]]
      next_states << [(state[0] + state[3]) % 10, state[1], state[2], state[3]]
      next_states << [state[0], (state[1] + state[2]) % 10, state[2], state[3]]
      next_states << [state[0], (state[1] + state[3]) % 10, state[2], state[3]]
    elsif player == 1
      next_states << [state[0], state[1], (state[2] + state[0]) % 10, state[3]]
      next_states << [state[0], state[1], (state[2] + state[1]) % 10, state[3]]
      next_states << [state[0], state[1], state[2], (state[3] + state[0]) % 10]
      next_states << [state[0], state[1], state[2], (state[3] + state[1]) % 10]     
    end
    next_states
  end
  
  def rearrage_state(state)
    if state[0] > state[1]
      temp = state[0]
      state[0] = state[1]
      state[1] = temp
    end
    if state[2] > state[3]
      temp = state[2]
      state[3] = state[2]
      state[2] = temp
    end
  end
end

ab = AlphaBeta.new
puts ab.solve([1,1,1,1], 0)
