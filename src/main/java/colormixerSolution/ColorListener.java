package colormixerSolution;

import java.awt.*;

// Pull model: observer queries what has changed:
//             s.getTemperature()
// Push model: update(temperature)
// One or more observables: If multiple observables
//                          then the observable
//                          would also be provided

public interface ColorListener {
    // "update"
    void colorValueChanged(Color c);
}
