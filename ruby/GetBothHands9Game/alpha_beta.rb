require 'set'

class AlphaBeta

  def initialize
    @state_set = Set.new
  end

  def solve(state, player)
    @state_set << state
    next_states = successor_states(state, player)
    scores = []

    if goal_state?
      return score(state)

    for s in next_states
      rearrage_state(s)
      unless checked? s
        scores << solve(s, (player + 1) % 2)
      end
    end

    if scores.any?    
      if player == 0
        return scores.max
      elsif player == 1
        return scores.min
      end
    else
      return 0
  end

  def goal_state?(state)
    if state[0] == 9 && state[1] == 9
      true
    elsif state[2] == 9 && state[3] == 9
      true
    else
      false
  end

  def checked?(state)
    @state_set.include? state
  end

  def score(state)
    if state[0] == 9 && state[1] == 9
      10
    elsif state[2] == 9 && state[3] == 9
      -10
    end
  end

  def successor_states(state, player)
    next_states = []
    if player == 0
      next_states << ([state[0] + state[2], state[1], state[2], state[3]])
      next_states << ([state[0] + state[3], state[1], state[2], state[3]])
      next_states << ([state[0], state[1] + state[2], state[2], state[3]])
      next_states << ([state[0], state[1] + state[3], state[2], state[3]])
    else
      next_states << ([state[0], state[1], state[2] + state[0], state[3]])
      next_states << ([state[0], state[1], state[2] + state[1], state[3]])
      next_states << ([state[0], state[1], state[2], state[3] + state[0]])
      next_states << ([state[0], state[1], state[2], state[3] + state[1]])      
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
puts ab.checked?(2)
print ab.successor_states([1,2,3,4], 0)
print ab.successor_states([1,2,3,4], 1)
