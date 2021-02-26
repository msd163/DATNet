package main.java.profiler;

import main.java._type.TtCapacityProfiler;
import static main.java._type.TtCapacityProfiler.*;

import main.java.utils.DefParameter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CapacityProfiler {
    List<List<DefParameter>> BunchOfIndividualsCapacity;

    public void LoadCapacityProfile(String fileName)
    {
        //todo: file read procedure should be completed.

        FileInputStream capFile = null;
        try {
            capFile = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
            e.printStackTrace();
            return;
        }
        Scanner sc = new Scanner(capFile);
        BunchOfIndividualsCapacity = new ArrayList<List<DefParameter>>();
//        BunchOfIndividualsCapacity.clear();
        while (sc.hasNextLine())
        {
            BunchOfIndividualsCapacity.add(
                    LoadCapacityProfileOfSingleBunch(sc.nextLine())
                    );
        }
    }
    private List<DefParameter> LoadCapacityProfileOfSingleBunch(String SingleLineOfFile)
    {
        List<DefParameter> SingleBunch = new ArrayList<DefParameter>();
        DefParameter temp;
        String[] cap = SingleLineOfFile.split("\\s+");
//        SingleBunch.clear();

        for (int p = 0; p < cap.length ; p++) //CapacityParameterCount.ordinal()
        {
            SingleBunch.add(new DefParameter(cap[p]));
        }

        return SingleBunch;
    }

    public int getCapNextValue(int BunchNumber, TtCapacityProfiler CapNumber)
    {
        return BunchOfIndividualsCapacity.get(BunchNumber).get(CapNumber.ordinal()).nextValue();
    }


    public int bunchCount() {
        return BunchOfIndividualsCapacity.size();
    }
}