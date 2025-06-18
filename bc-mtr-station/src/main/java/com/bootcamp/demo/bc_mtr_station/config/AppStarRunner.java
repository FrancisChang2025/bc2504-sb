package com.bootcamp.demo.bc_mtr_station.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.service.LineService;
import com.bootcamp.demo.bc_mtr_station.service.StationService;

// Server start
@Component
public class AppStarRunner implements CommandLineRunner {
    @Autowired
    private LineService lineService;
    @Autowired
    private StationService stationService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");

        // AEL
        LineEntity aelLineEntity = LineEntity.builder().code("AEL") //
                .description("Airport Express").build();

        List<StationEntity> aelStationEntities = new ArrayList<>();

        StationEntity hokEntity = StationEntity.builder().code("HOK") //
                .description("Hong Kong").lineEntity(aelLineEntity).build();
        StationEntity kowEntity = StationEntity.builder().code("KOW") //
                .description("Kowloon").lineEntity(aelLineEntity).build();
        StationEntity tsyEntity = StationEntity.builder().code("TSY") //
                .description("Tsing Yi").lineEntity(aelLineEntity).build();
        StationEntity airEntity = StationEntity.builder().code("AIR") //
                .description("Airport").lineEntity(aelLineEntity).build();
        StationEntity aweEntity = StationEntity.builder().code("AWE") //
                .description("AsiaWorld Expo").lineEntity(aelLineEntity)
                .build();

        aelStationEntities.add(hokEntity);
        aelStationEntities.add(kowEntity);
        aelStationEntities.add(tsyEntity);
        aelStationEntities.add(airEntity);
        aelStationEntities.add(aweEntity);

        // TCL
        LineEntity tclLineEntity = LineEntity.builder().code("TCL")
                .description("Tung Chung Line").build();

        List<StationEntity> tclStationEntities = new ArrayList<>();

        tclStationEntities.add(StationEntity.builder().code("HOK") //
                .description("Hong Kong").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("KOW") //
                .description("Kowloon").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("OLY") //
                .description("Olympic").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("NAC") //
                .description("Nam Cheong").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("LAK") //
                .description("Lai King").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("TSY") //
                .description("Tsing Yi").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("SUN") //
                .description("Sunny Bay").lineEntity(tclLineEntity).build());
        tclStationEntities.add(StationEntity.builder().code("TUC") //
                .description("Tung Chung").lineEntity(tclLineEntity).build());

        // TML
        LineEntity tmlLineEntity = LineEntity.builder().code("TML")
                .description("Tuen Ma Line").build();

        List<StationEntity> tmlStationEntities = new ArrayList<>();

        tmlStationEntities.add(StationEntity.builder().code("WKS") //
           .description("Wu Kai Sha").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("MOS") //
           .description("Ma On Shan").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("HEO") //
           .description("Heng On").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TSH") //
           .description("Tai Shui Hang").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("SHM") //
           .description("Shek Mun").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("CIO") //
           .description("City One").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("STW") //
           .description("Sha Tin Wai").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("CKT") //
           .description("Che Kung Temple").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TAW") //
           .description("Tai Wai").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("HIK") //
           .description("Hin Keng").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("DIH") //
           .description("Diamond Hill").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("KAT") //
           .description("Kai Tak").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("SWT") //
           .description("Sung Wong Toi").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TKW") //
           .description("To Kwa Wan").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("HMT") //
            .description("Ho Man Tin").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("HUH") //
           .description("Hung Hom").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("ETS") //
           .description("East Tsim Sha Tsui").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("AUS") //
           .description("Austin").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("NAC") //
           .description("Nam Cheong").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("MEF") //
           .description("Mei Foo").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TWW") //
           .description("Tsuen Wan West").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("KSR") //
           .description("Kam Sheung Road").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("YUL") //
           .description("Yuen Long").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("LOP") //
           .description("Long Ping").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TSW") //
           .description("Tin Shui Wai").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("SIH") //
           .description("Siu Hong").lineEntity(tmlLineEntity).build());
        tmlStationEntities.add(StationEntity.builder().code("TUM") //
           .description("Tuen Mun").lineEntity(tmlLineEntity).build());

        // TKL
        LineEntity tklLineEntity = LineEntity.builder().code("TKL")
                .description("Tseung Kwan O Line").build();

        List<StationEntity> tklStationEntities = new ArrayList<>();

        tklStationEntities.add(StationEntity.builder().code("NOP") //
           .description("North Point").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("QUB") //
           .description("Quarry Bay").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("YAT") //
           .description("Yau Tong").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("TIK") //
           .description("Tiu Keng Leng").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("TKO") //
           .description("Tseung Kwan O").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("LHP") //
           .description("LOHAS Park").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("HAH") //
           .description("Hang Hau").lineEntity(tklLineEntity).build());
        tklStationEntities.add(StationEntity.builder().code("POA") //
           .description("Po Lam").lineEntity(tklLineEntity).build());

        // EAL
        LineEntity ealLineEntity = LineEntity.builder().code("EAL")
           .description("East Rail Line").build();

        List<StationEntity> ealStationEntities = new ArrayList<>();

        ealStationEntities.add(StationEntity.builder().code("ADM") //
            .description("Admiralty").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("EXC") //
            .description("Exhibition Centre").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("HUH") //
            .description("Hung Hom").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("MKE") //
            .description("Mong Kok East").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("KOT") //
            .description("Kowloon Tong").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("TAW") //
            .description("Tai Wai").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("SHT") //
            .description("Sha Tin").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("FOT") //
            .description("Fo Tan").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("RAC") //
            .description("Racecourse").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("UNI") //
            .description("University").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("TPM") //
            .description("Tai Po Market").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("TWO") //
            .description("Tai Wo").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("FAN") //
            .description("Fanling").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("SHS") //
            .description("Sheung Shui").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("LOW") //
            .description("Lo Wu").lineEntity(ealLineEntity).build());
        ealStationEntities.add(StationEntity.builder().code("LMC") //
            .description("Lok Ma Chau").lineEntity(ealLineEntity).build());

        // SIL
        LineEntity silLineEntity = LineEntity.builder().code("SIL")
           .description("South Island Line").build();

        List<StationEntity> silStationEntities = new ArrayList<>();

        silStationEntities.add(StationEntity.builder().code("ADM") //
            .description("Admiralty").lineEntity(silLineEntity).build());
        silStationEntities.add(StationEntity.builder().code("OCP") //
            .description("Ocean Park").lineEntity(silLineEntity).build());
        silStationEntities.add(StationEntity.builder().code("WCH") //
            .description("Wong Chuk Hang").lineEntity(silLineEntity).build());
        silStationEntities.add(StationEntity.builder().code("LET") //
            .description("Lei Tung").lineEntity(silLineEntity).build());
        silStationEntities.add(StationEntity.builder().code("SOH") //
            .description("South Horizons").lineEntity(silLineEntity).build());

        // TWL
        LineEntity twlLineEntity = LineEntity.builder().code("TWL")
           .description("Tsuen Wan Line").build();

        List<StationEntity> twlStationEntities = new ArrayList<>();

        twlStationEntities.add(StationEntity.builder().code("CEN") //
            .description("Central").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("ADM") //
            .description("Admiralty").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("TST") //
            .description("Tsim Sha Tsui").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("JOR") //
            .description("Jordan").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("YMT") //
            .description("Yau Ma Tei").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("MOK") //
            .description("Mong Kok").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("PRE") //
            .description("Prince Edward").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("SSP") //
            .description("Sham Shui Po").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("CSW") //
            .description("Cheung Sha Wan").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("LCK") //
            .description("Lai Chi Kok").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("MEF") //
            .description("Mei Foo").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("LAK") //
            .description("Lai King").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("KWF") //
            .description("Kwai Fong").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("KWH") //
            .description("Kwai Hing").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("TWH") //
            .description("Tai Wo Hau").lineEntity(twlLineEntity).build());
        twlStationEntities.add(StationEntity.builder().code("TSW") //
            .description("Tsuen Wan").lineEntity(twlLineEntity).build());

        // ISL
        LineEntity islLineEntity = LineEntity.builder().code("ISL")
           .description("Island Line").build();

        List<StationEntity> islStationEntities = new ArrayList<>();

        islStationEntities.add(StationEntity.builder().code("KET") //
            .description("Kennedy Town").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("HU") //
            .description("HKU").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("SYP") //
            .description("Sai Ying Pun").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("SHW") //
            .description("Sheung Wan").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("CEN") //
            .description("Central").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("ADM") //
            .description("Admiralty").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("WAC") //
            .description("Wan Chai").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("CAB") //
            .description("Causeway Bay").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("TIH") //
            .description("Tin Hau").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("FOH") //
            .description("Fortress Hill").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("NOP") //
            .description("North Point").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("QUB") //
            .description("Quarry Bay").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("TAK") //
            .description("Tai Koo").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("SWH") //
            .description("Sai Wan Ho").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("SKW") //
            .description("Shau Kei Wan").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("HFC") //
            .description("Heng Fa Chuen").lineEntity(islLineEntity).build());
        islStationEntities.add(StationEntity.builder().code("CHW") //
            .description("Chai Wan").lineEntity(islLineEntity).build());

        // KTL
        LineEntity ktlLineEntity = LineEntity.builder().code("KTL")
           .description("Kwun Tong Line").build();

        List<StationEntity> ktlStationEntities = new ArrayList<>();

        ktlStationEntities.add(StationEntity.builder().code("WHA") //
            .description("Whampoa").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("HMT") //
            .description("Ho Man Tin").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("YMT") //
            .description("Yau Ma Tei").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("MOK") //
            .description("Mong Kok").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("PRE") //
            .description("Prince Edward").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("SKM") //
            .description("Shek Kip Mei").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("KOT") //
            .description("Kowloon Tong").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("LOF") //
            .description("Lok Fu").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("WTS") //
            .description("Wong Tai Sin").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("DIH") //
            .description("Diamond Hill").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("CHH") //
            .description("Choi Hung").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("KOB") //
            .description("Kowloon Bay").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("NTK") //
            .description("Ngau Tau Kok").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("KWT") //
            .description("Kwun Tong").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("LAT") //
            .description("Lam Tin").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("YAT") //
            .description("Yau Tong").lineEntity(ktlLineEntity).build());
        ktlStationEntities.add(StationEntity.builder().code("TIK") //
            .description("Tiu Keng Leng").lineEntity(ktlLineEntity).build());

        // DRL
        LineEntity drlLineEntity = LineEntity.builder().code("DRL")
           .description("Disneyland Resort Line").build();

        List<StationEntity> drlStationEntities = new ArrayList<>();

        drlStationEntities.add(StationEntity.builder().code("SUN") //
            .description("Sunny Bay").lineEntity(drlLineEntity).build());
        drlStationEntities.add(StationEntity.builder().code("DIS") //
            .description("Disneyland Resort").lineEntity(drlLineEntity).build());

        // insert into database tables (mtr_lines and mtr_stations)
        this.lineService.save(aelLineEntity);
        this.lineService.save(tclLineEntity);
        this.lineService.save(tmlLineEntity);
        this.lineService.save(tklLineEntity);
        this.lineService.save(ealLineEntity);
        this.lineService.save(silLineEntity);
        this.lineService.save(twlLineEntity);
        this.lineService.save(islLineEntity);
        this.lineService.save(ktlLineEntity);
        this.lineService.save(drlLineEntity);
        this.stationService.saveAll(aelStationEntities); // @Nonnull -> check if fields are null
        this.stationService.saveAll(tclStationEntities);
        this.stationService.saveAll(tmlStationEntities);
        this.stationService.saveAll(tklStationEntities);
        this.stationService.saveAll(ealStationEntities);
        this.stationService.saveAll(silStationEntities);
        this.stationService.saveAll(twlStationEntities);
        this.stationService.saveAll(islStationEntities);
        this.stationService.saveAll(ktlStationEntities);
        this.stationService.saveAll(drlStationEntities);

    }
}
