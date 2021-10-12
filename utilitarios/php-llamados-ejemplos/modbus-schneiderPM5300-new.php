<?php
$IP = $argv[1];
$EQUIPO = $argv[2];
$IDREM = $argv[3];
$salida = shell_exec("/usr/src/modpoll/linux_x86-64/modpoll -m enc -t4:hex -a $IDREM  -r 2700 -c 26 -1 -o 1 $IP -p 1024");
  $inicioD1 = strrpos($salida, "[2700]")+7;
  $finD1 = strrpos($salida, "[2701]");
  $finD1 = $finD1 - strlen($salida);
  $D1 = substr($salida, $inicioD1,  $finD1);
echo "P1=$D1";
  $inicioD2 = strrpos($salida, "[2701]")+7;
  $finD2 = strrpos($salida, "[2702]");
  $finD2 = $finD2 - strlen($salida);
  $D2= substr($salida, $inicioD2,  $finD2);
echo "P2=$D2";
  $inicioD3 = strrpos($salida, "[2702]")+7;
  $finD3 = strrpos($salida, "[2703]");
  $finD3 = $finD3 - strlen($salida);
  $D3 = substr($salida, $inicioD3,  $finD3);
echo "P3=$D3";
  $inicioD4 = strrpos($salida, "[2703]")+7;
  $finD4 = strrpos($salida, "[2704]");
  $finD4 = $finD4 - strlen($salida);
  $D4 = substr($salida, $inicioD4,  $finD4);
echo "P4=$D4";
  $inicioD5 = strrpos($salida, "[2704]")+7;
  $finD5 = strrpos($salida, "[2705]");
  $finD5 = $finD5 - strlen($salida);
  $D5 = substr($salida, $inicioD5,  $finD5);
echo "P5=$D5";
  $inicioD6 = strrpos($salida, "[2705]")+7;
  $finD6 = strrpos($salida, "[2706]");
  $finD6 = $finD6 - strlen($salida);
  $D6 = substr($salida, $inicioD6,  $finD6);
echo "P6=$D6";
  $inicioD7 = strrpos($salida, "[2706]")+7;
  $finD7 = strrpos($salida, "[2707]");
  $finD7 = $finD7 - strlen($salida);
  $D7 = substr($salida, $inicioD7,  $finD7);
echo "P7=$D7";
  $inicioD8 = strrpos($salida, "[2707]")+7;
  $finD8 = strrpos($salida, "[2708]");
  $finD8 = $finD8 - strlen($salida);
  $D8 = substr($salida, $inicioD8,  $finD8);
echo "P8=$D8";
  $inicioD9 = strrpos($salida, "[2708]")+7;
  $finD9 = strrpos($salida, "[2709]");
  $finD9 = $finD9 - strlen($salida);
  $D9 = substr($salida, $inicioD9,  $finD9);
echo "P9=$D9";
  $inicioD10 = strrpos($salida, "[2709]")+7;
  $finD10 = strrpos($salida, "[2710]");
  $finD10 = $finD10 - strlen($salida);
  $D10 = substr($salida, $inicioD10,  $finD10);
echo "P10=$D10";
  $inicioD11 = strrpos($salida, "[2710]")+7;
  $finD11 = strrpos($salida, "[2711]");
  $finD11 = $finD11 - strlen($salida);
  $D11 = substr($salida, $inicioD11,  $finD11);
echo "P11=$D11";
  $inicioD12 = strrpos($salida, "[2711]")+7;
  $finD12 = strrpos($salida, "[2712]");
  $finD12 = $finD12 - strlen($salida);
  $D12 = substr($salida, $inicioD12,  $finD12);
echo "P12=$D12";
  $inicioD13 = strrpos($salida, "[2712]")+7;
  $finD13 = strrpos($salida, "[2713]");
  $finD13 = $finD13 - strlen($salida);
  $D13 = substr($salida, $inicioD13,  $finD13);
echo "P13=$D13";
  $inicioD14 = strrpos($salida, "[2713]")+7;
  $finD14 = strrpos($salida, "[2714]");
  $finD14 = $finD14 - strlen($salida);
  $D14 = substr($salida, $inicioD14,  $finD14);
echo "P14=$D14";
  $inicioD15 = strrpos($salida, "[2714]")+7;
  $finD15 = strrpos($salida, "[2715]");
  $finD15 = $finD15 - strlen($salida);
  $D15 = substr($salida, $inicioD15,  $finD15);
echo "P15=$D15";
  $inicioD16 = strrpos($salida, "[2715]")+7;
  $finD16 = strrpos($salida, "[2716]");
  $finD16 = $finD16 - strlen($salida);
  $D16 = substr($salida, $inicioD16,  $finD16);
echo "P16=$D16";
  $inicioD17 = strrpos($salida, "[2716]")+7;
  $finD17 = strrpos($salida, "[2717]");
  $finD17 = $finD17 - strlen($salida);
  $D17 = substr($salida, $inicioD17,  $finD17);
echo "P17=$D17";
  $inicioD18 = strrpos($salida, "[2717]")+7;
  $finD18 = strrpos($salida, "[2718]");
  $finD18 = $finD18 - strlen($salida);
  $D18 = substr($salida, $inicioD18,  $finD18);
echo "P18=$D18";
  $inicioD19 = strrpos($salida, "[2718]")+7;
  $finD19 = strrpos($salida, "[2719]");
  $finD19 = $finD19 - strlen($salida);
  $D19 = substr($salida, $inicioD19,  $finD19);
echo "P19=$D19";
  $inicioD20 = strrpos($salida, "[2719]")+7;
  $finD20 = strrpos($salida, "[2720]");
  $finD20 = $finD20 - strlen($salida);
  $D20 = substr($salida, $inicioD20,  $finD20);
echo "P20=$D20";
  $inicioD21 = strrpos($salida, "[2720]")+7;
  $finD21 = strrpos($salida, "[2721]");
  $finD21 = $finD21 - strlen($salida);
  $D21 = substr($salida, $inicioD21,  $finD21);
echo "P21=$D21";
  $inicioD22 = strrpos($salida, "[2721]")+7;
  $finD22 = strrpos($salida, "[2722]");
  $finD22 = $finD22 - strlen($salida);
  $D22 = substr($salida, $inicioD22,  $finD22);
echo "P22=$D22";
  $inicioD23 = strrpos($salida, "[2722]")+7;
  $finD23 = strrpos($salida, "[2723]");
  $finD23 = $finD23 - strlen($salida);
  $D23 = substr($salida, $inicioD23,  $finD23);
echo "P23=$D23";
  $inicioD24 = strrpos($salida, "[2723]")+7;
  $finD24 = strrpos($salida, "[2724]");
  $finD24 = $finD24 - strlen($salida);
  $D24 = substr($salida, $inicioD24,  $finD24);
echo "P24=$D24";
$salida2 = shell_exec("/usr/src/modpoll/linux_x86-64/modpoll -m enc -t4:hex -a $IDREM  -r 3000 -c 95 -1 -o 1 $IP -p 1024");
  $inicioD25 = strrpos($salida2, "[3000]")+6;
  $finD25 = strrpos($salida2, "[3001]");
  $finD25 = $finD25 - strlen($salida2);
  $D25 = substr($salida2, $inicioD25,  $finD25);
echo "P25=$D25";
  $inicioD26 = strrpos($salida2, "[3001]")+6;
  $finD26 = strrpos($salida2, "[3002]");
  $finD26 = $finD26 - strlen($salida2);
  $D26 = substr($salida2, $inicioD26,  $finD26);
echo "P26=$D26";
  $inicioD27 = strrpos($salida2, "[3002]")+6;
  $finD27 = strrpos($salida2, "[3003]");
  $finD27 = $finD27 - strlen($salida2);
  $D27 = substr($salida2, $inicioD27,  $finD27);
echo "P27=$D27";
  $inicioD28 = strrpos($salida2, "[3003]")+6;
  $finD28 = strrpos($salida2, "[3004]");
  $finD28 = $finD28 - strlen($salida2);
  $D28 = substr($salida2, $inicioD28,  $finD28);
echo "P28=$D28";
  $inicioD29 = strrpos($salida2, "[3004]")+6;
  $finD29 = strrpos($salida2, "[3005]");
  $finD29 = $finD29 - strlen($salida2);
  $D29 = substr($salida2, $inicioD29,  $finD29);
echo "P29=$D29";
  $inicioD30 = strrpos($salida2, "[3005]")+6;
  $finD30 = strrpos($salida2, "[3006]");
  $finD30 = $finD30 - strlen($salida2);
  $D30 = substr($salida2, $inicioD30,  $finD30);
echo "P30=$D30";
  $inicioD31 = strrpos($salida2, "[3006]")+6;
  $finD31 = strrpos($salida2, "[3007]");
  $finD31 = $finD31 - strlen($salida2);
  $D31 = substr($salida2, $inicioD31,  $finD31);
echo "P31=$D31";
  $inicioD32 = strrpos($salida2, "[3007]")+6;
  $finD32 = strrpos($salida2, "[3008]");
  $finD32 = $finD32 - strlen($salida2);
  $D32 = substr($salida2, $inicioD32,  $finD32);
echo "P32=$D32";
  $inicioD33 = strrpos($salida2, "[3008]")+6;
  $finD33 = strrpos($salida2, "[3009]");
  $finD33 = $finD33 - strlen($salida2);
  $D33 = substr($salida2, $inicioD33,  $finD33);
echo "P33=$D33";
  $inicioD34 = strrpos($salida2, "[3009]")+6;
  $finD34 = strrpos($salida2, "[3010]");
  $finD34 = $finD34 - strlen($salida2);
  $D34 = substr($salida2, $inicioD34,  $finD34);
echo "P34=$D34";
  $inicioD35 = strrpos($salida2, "[3010]")+6;
  $finD35 = strrpos($salida2, "[3011]");
  $finD35 = $finD35 - strlen($salida2);
  $D35 = substr($salida2, $inicioD35,  $finD35);
echo "P35=$D35";
  $inicioD36 = strrpos($salida2, "[3011]")+6;
  $finD36 = strrpos($salida2, "[3012]");
  $finD36 = $finD36 - strlen($salida2);
  $D36 = substr($salida2, $inicioD36,  $finD36);
echo "P36=$D36";
  $inicioD37 = strrpos($salida2, "[3012]")+6;
  $finD37 = strrpos($salida2, "[3013]");
  $finD37 = $finD37 - strlen($salida2);
  $D37 = substr($salida2, $inicioD37,  $finD37);
echo "P37=$D37";
  $inicioD38 = strrpos($salida2, "[3013]")+6;
  $finD38 = strrpos($salida2, "[3014]");
  $finD38 = $finD38 - strlen($salida2);
  $D38 = substr($salida2, $inicioD38,  $finD38);
echo "P38=$D38";
  $inicioD39 = strrpos($salida2, "[3014]")+6;
  $finD39 = strrpos($salida2, "[3015]");
  $finD39 = $finD39 - strlen($salida2);
  $D39 = substr($salida2, $inicioD39,  $finD39);
echo "P39=$D39";
  $inicioD40 = strrpos($salida2, "[3015]")+6;
  $finD40 = strrpos($salida2, "[3016]");
  $finD40 = $finD40 - strlen($salida2);
  $D40 = substr($salida2, $inicioD40,  $finD40);
echo "P40=$D40";
  $inicioD41 = strrpos($salida2, "[3016]")+6;
  $finD41 = strrpos($salida2, "[3017]");
  $finD41 = $finD41 - strlen($salida2);
  $D41 = substr($salida2, $inicioD41,  $finD41);
echo "P41=$D41";
  $inicioD42 = strrpos($salida2, "[3017]")+6;
  $finD42 = strrpos($salida2, "[3018]");
  $finD42 = $finD42 - strlen($salida2);
  $D42 = substr($salida2, $inicioD42,  $finD42);
echo "P42=$D42";
  $inicioD43 = strrpos($salida2, "[3018]")+6;
  $finD43 = strrpos($salida2, "[3019]");
  $finD43 = $finD43 - strlen($salida2);
  $D43 = substr($salida2, $inicioD43,  $finD43);
echo "P43=$D43";
  $inicioD44 = strrpos($salida2, "[3019]")+6;
  $finD44 = strrpos($salida2, "[3020]");
  $finD44 = $finD44 - strlen($salida2);
  $D44 = substr($salida2, $inicioD44,  $finD44);
echo "P44=$D44";
  $inicioD45 = strrpos($salida2, "[3020]")+6;
  $finD45 = strrpos($salida2, "[3021]");
  $finD45 = $finD45 - strlen($salida2);
  $D45 = substr($salida2, $inicioD45,  $finD45);
echo "P45=$D45";
  $inicioD46 = strrpos($salida2, "[3021]")+6;
  $finD46 = strrpos($salida2, "[3022]");
  $finD46 = $finD46 - strlen($salida2);
  $D46 = substr($salida2, $inicioD46,  $finD46);
echo "P46=$D46";
  $inicioD47 = strrpos($salida2, "[3022]")+6;
  $finD47 = strrpos($salida2, "[3023]");
  $finD47 = $finD47 - strlen($salida2);
  $D47 = substr($salida2, $inicioD47,  $finD47);
echo "P47=$D47";
  $inicioD48 = strrpos($salida2, "[3023]")+6;
  $finD48 = strrpos($salida2, "[3024]");
  $finD48 = $finD48 - strlen($salida2);
  $D48 = substr($salida2, $inicioD48,  $finD48);
echo "P48=$D48";
  $inicioD49 = strrpos($salida2, "[3024]")+6;
  $finD49 = strrpos($salida2, "[3025]");
  $finD49 = $finD49 - strlen($salida2);
  $D49 = substr($salida2, $inicioD49,  $finD49);
echo "P49=$D49";
  $inicioD50 = strrpos($salida2, "[3025]")+6;
  $finD50 = strrpos($salida2, "[3026]");
  $finD50 = $finD50 - strlen($salida2);
  $D50 = substr($salida2, $inicioD50,  $finD50);
echo "P50=$D50";
  $inicioD51 = strrpos($salida2, "[3026]")+6;
  $finD51 = strrpos($salida2, "[3027]");
  $finD51 = $finD51 - strlen($salida2);
  $D51 = substr($salida2, $inicioD51,  $finD51);
echo "P51=$D51";
  $inicioD52 = strrpos($salida2, "[3027]")+6;
  $finD52 = strrpos($salida2, "[3028]");
  $finD52 = $finD52 - strlen($salida2);
  $D52 = substr($salida2, $inicioD52,  $finD52);
echo "P52=$D52";
  $inicioD53 = strrpos($salida2, "[3028]")+6;
  $finD53 = strrpos($salida2, "[3029]");
  $finD53 = $finD53 - strlen($salida2);
  $D53 = substr($salida2, $inicioD53,  $finD53);
echo "P53=$D53";
  $inicioD54 = strrpos($salida2, "[3029]")+6;
  $finD54 = strrpos($salida2, "[3030]");
  $finD54 = $finD54 - strlen($salida2);
  $D54 = substr($salida2, $inicioD54,  $finD54);
echo "P54=$D54";
  $inicioD55 = strrpos($salida2, "[3030]")+6;
  $finD55 = strrpos($salida2, "[3031]");
  $finD55 = $finD55 - strlen($salida2);
  $D55 = substr($salida2, $inicioD55,  $finD55);
echo "P55=$D55";
  $inicioD56 = strrpos($salida2, "[3031]")+6;
  $finD56 = strrpos($salida2, "[3032]");
  $finD56 = $finD56 - strlen($salida2);
  $D56 = substr($salida2, $inicioD56,  $finD56);
echo "P56=$D56";
  $inicioD57 = strrpos($salida2, "[3032]")+6;
  $finD57 = strrpos($salida2, "[3033]");
  $finD57 = $finD57 - strlen($salida2);
  $D57 = substr($salida2, $inicioD57,  $finD57);
echo "P57=$D57";
  $inicioD58 = strrpos($salida2, "[3033]")+6;
  $finD58 = strrpos($salida2, "[3034]");
  $finD58 = $finD58 - strlen($salida2);
  $D58 = substr($salida2, $inicioD58,  $finD58);
echo "P58=$D58";
  $inicioD59 = strrpos($salida2, "[3034]")+6;
  $finD59 = strrpos($salida2, "[3035]");
  $finD59 = $finD59 - strlen($salida2);
  $D59 = substr($salida2, $inicioD59,  $finD59);
echo "P59=$D59";
  $inicioD60 = strrpos($salida2, "[3035]")+6;
  $finD60 = strrpos($salida2, "[3036]");
  $finD60 = $finD60 - strlen($salida2);
  $D60 = substr($salida2, $inicioD60,  $finD60);
echo "P60=$D60";
  $inicioD61 = strrpos($salida2, "[3036]")+6;
  $finD61 = strrpos($salida2, "[3037]");
  $finD61 = $finD61 - strlen($salida2);
  $D61 = substr($salida2, $inicioD61,  $finD61);
echo "P61=$D61";
  $inicioD62 = strrpos($salida2, "[3037]")+6;
  $finD62 = strrpos($salida2, "[3038]");
  $finD62 = $finD62 - strlen($salida2);
  $D62 = substr($salida2, $inicioD62,  $finD62);
echo "P62=$D62";
  $inicioD63 = strrpos($salida2, "[3038]")+6;
  $finD63 = strrpos($salida2, "[3039]");
  $finD63 = $finD63 - strlen($salida2);
  $D63 = substr($salida2, $inicioD63,  $finD63);
echo "P63=$D63";
  $inicioD64 = strrpos($salida2, "[3039]")+6;
  $finD64 = strrpos($salida2, "[3040]");
  $finD64 = $finD64 - strlen($salida2);
  $D64 = substr($salida2, $inicioD64,  $finD64);
echo "P64=$D64";
  $inicioD65 = strrpos($salida2, "[3040]")+6;
  $finD65 = strrpos($salida2, "[3041]");
  $finD65 = $finD65 - strlen($salida2);
  $D65 = substr($salida2, $inicioD65,  $finD65);
echo "P65=$D65";
  $inicioD66 = strrpos($salida2, "[3041]")+6;
  $finD66 = strrpos($salida2, "[3042]");
  $finD66 = $finD66 - strlen($salida2);
  $D66 = substr($salida2, $inicioD66,  $finD66);
echo "P66=$D66";
  $inicioD67 = strrpos($salida2, "[3042]")+6;
  $finD67 = strrpos($salida2, "[3043]");
  $finD67 = $finD67 - strlen($salida2);
  $D67 = substr($salida2, $inicioD67,  $finD67);
echo "P67=$D67";
  $inicioD68 = strrpos($salida2, "[3043]")+6;
  $finD68 = strrpos($salida2, "[3044]");
  $finD68 = $finD68 - strlen($salida2);
  $D68 = substr($salida2, $inicioD68,  $finD68);
echo "P68=$D68";
  $inicioD69 = strrpos($salida2, "[3044]")+6;
  $finD69 = strrpos($salida2, "[3045]");
  $finD69 = $finD69 - strlen($salida2);
  $D69 = substr($salida2, $inicioD69,  $finD69);
echo "P69=$D69";
  $inicioD70 = strrpos($salida2, "[3045]")+6;
  $finD70 = strrpos($salida2, "[3046]");
  $finD70 = $finD70 - strlen($salida2);
  $D70 = substr($salida2, $inicioD70,  $finD70);
echo "P70=$D70";
  $inicioD71 = strrpos($salida2, "[3046]")+6;
  $finD71 = strrpos($salida2, "[3047]");
  $finD71 = $finD71 - strlen($salida2);
  $D71 = substr($salida2, $inicioD71,  $finD71);
echo "P71=$D71";
  $inicioD72 = strrpos($salida2, "[3047]")+6;
  $finD72 = strrpos($salida2, "[3048]");
  $finD72 = $finD72 - strlen($salida2);
  $D72 = substr($salida2, $inicioD72,  $finD72);
echo "P72=$D72";
  $inicioD73 = strrpos($salida2, "[3048]")+6;
  $finD73 = strrpos($salida2, "[3049]");
  $finD73 = $finD73 - strlen($salida2);
  $D73 = substr($salida2, $inicioD73,  $finD73);
echo "P73=$D73";
  $inicioD74 = strrpos($salida2, "[3049]")+6;
  $finD74 = strrpos($salida2, "[3050]");
  $finD74 = $finD74 - strlen($salida2);
  $D74 = substr($salida2, $inicioD74,  $finD74);
echo "P74=$D74";
  $inicioD75 = strrpos($salida2, "[3050]")+6;
  $finD75 = strrpos($salida2, "[3051]");
  $finD75 = $finD75 - strlen($salida2);
  $D75 = substr($salida2, $inicioD75,  $finD75);
echo "P75=$D75";
  $inicioD76 = strrpos($salida2, "[3051]")+6;
  $finD76 = strrpos($salida2, "[3052]");
  $finD76 = $finD76 - strlen($salida2);
  $D76 = substr($salida2, $inicioD76,  $finD76);
echo "P76=$D76";
  $inicioD77 = strrpos($salida2, "[3052]")+6;
  $finD77 = strrpos($salida2, "[3053]");
  $finD77 = $finD77 - strlen($salida2);
  $D77 = substr($salida2, $inicioD77,  $finD77);
echo "P77=$D77";
  $inicioD78 = strrpos($salida2, "[3053]")+6;
  $finD78 = strrpos($salida2, "[3054]");
  $finD78 = $finD78 - strlen($salida2);
  $D78 = substr($salida2, $inicioD78,  $finD78);
echo "P78=$D78";
  $inicioD79 = strrpos($salida2, "[3054]")+6;
  $finD79 = strrpos($salida2, "[3055]");
  $finD79 = $finD79 - strlen($salida2);
  $D79 = substr($salida2, $inicioD79,  $finD79);
echo "P79=$D79";
  $inicioD80 = strrpos($salida2, "[3055]")+6;
  $finD80 = strrpos($salida2, "[3056]");
  $finD80 = $finD80 - strlen($salida2);
  $D80 = substr($salida2, $inicioD80,  $finD80);
echo "P80=$D80";
  $inicioD81 = strrpos($salida2, "[3056]")+6;
  $finD81 = strrpos($salida2, "[3057]");
  $finD81 = $finD81 - strlen($salida2);
  $D81 = substr($salida2, $inicioD81,  $finD81);
echo "P81=$D81";
  $inicioD82 = strrpos($salida2, "[3057]")+6;
  $finD82 = strrpos($salida2, "[3058]");
  $finD82 = $finD82 - strlen($salida2);
  $D82 = substr($salida2, $inicioD82,  $finD82);
echo "P82=$D82";
  $inicioD83 = strrpos($salida2, "[3058]")+6;
  $finD83 = strrpos($salida2, "[3059]");
  $finD83 = $finD83 - strlen($salida2);
  $D83 = substr($salida2, $inicioD83,  $finD83);
echo "P83=$D83";
  $inicioD84 = strrpos($salida2, "[3059]")+6;
  $finD84 = strrpos($salida2, "[3060]");
  $finD84 = $finD84 - strlen($salida2);
  $D84 = substr($salida2, $inicioD84,  $finD84);
echo "P84=$D84";
  $inicioD85 = strrpos($salida2, "[3060]")+6;
  $finD85 = strrpos($salida2, "[3061]");
  $finD85 = $finD85 - strlen($salida2);
  $D85 = substr($salida2, $inicioD85,  $finD85);
echo "P85=$D85";
  $inicioD86 = strrpos($salida2, "[3061]")+6;
  $finD86 = strrpos($salida2, "[3062]");
  $finD86 = $finD86 - strlen($salida2);
  $D86 = substr($salida2, $inicioD86,  $finD86);
echo "P86=$D86";
  $inicioD87 = strrpos($salida2, "[3062]")+6;
  $finD87 = strrpos($salida2, "[3063]");
  $finD87 = $finD87 - strlen($salida2);
  $D87 = substr($salida2, $inicioD87,  $finD87);
echo "P87=$D87";
  $inicioD88 = strrpos($salida2, "[3063]")+6;
  $finD88 = strrpos($salida2, "[3064]");
  $finD88 = $finD88 - strlen($salida2);
  $D88 = substr($salida2, $inicioD88,  $finD88);
echo "P88=$D88";
  $inicioD89 = strrpos($salida2, "[3064]")+6;
  $finD89 = strrpos($salida2, "[3065]");
  $finD89 = $finD89 - strlen($salida2);
  $D89 = substr($salida2, $inicioD89,  $finD89);
echo "P89=$D89";
  $inicioD90 = strrpos($salida2, "[3065]")+6;
  $finD90 = strrpos($salida2, "[3066]");
  $finD90 = $finD90 - strlen($salida2);
  $D90 = substr($salida2, $inicioD90,  $finD90);
echo "P90=$D90";
  $inicioD91 = strrpos($salida2, "[3066]")+6;
  $finD91 = strrpos($salida2, "[3067]");
  $finD91 = $finD91 - strlen($salida2);
  $D91 = substr($salida2, $inicioD91,  $finD91);
echo "P91=$D91";
  $inicioD92 = strrpos($salida2, "[3067]")+6;
  $finD92 = strrpos($salida2, "[3068]");
  $finD92 = $finD92 - strlen($salida2);
  $D92 = substr($salida2, $inicioD92,  $finD92);
echo "P92=$D92";
  $inicioD93 = strrpos($salida2, "[3068]")+6;
  $finD93 = strrpos($salida2, "[3069]");
  $finD93 = $finD93 - strlen($salida2);
  $D93 = substr($salida2, $inicioD93,  $finD93);
echo "P93=$D93";
  $inicioD94 = strrpos($salida2, "[3069]")+6;
  $finD94 = strrpos($salida2, "[3070]");
  $finD94 = $finD94 - strlen($salida2);
  $D94 = substr($salida2, $inicioD94,  $finD94);
echo "P94=$D94";
  $inicioD95 = strrpos($salida2, "[3070]")+6;
  $finD95 = strrpos($salida2, "[3071]");
  $finD95 = $finD95 - strlen($salida2);
  $D95 = substr($salida2, $inicioD95,  $finD95);
echo "P95=$D95";
  $inicioD96 = strrpos($salida2, "[3071]")+6;
  $finD96 = strrpos($salida2, "[3072]");
  $finD96 = $finD96 - strlen($salida2);
  $D96 = substr($salida2, $inicioD96,  $finD96);
echo "P96=$D96";
  $inicioD97 = strrpos($salida2, "[3072]")+6;
  $finD97 = strrpos($salida2, "[3073]");
  $finD97 = $finD97 - strlen($salida2);
  $D97 = substr($salida2, $inicioD97,  $finD97);
echo "P97=$D97";
  $inicioD98 = strrpos($salida2, "[3073]")+6;
  $finD98 = strrpos($salida2, "[3074]");
  $finD98 = $finD98 - strlen($salida2);
  $D98 = substr($salida2, $inicioD98,  $finD98);
echo "P98=$D98";
  $inicioD99 = strrpos($salida2, "[3074]")+6;
  $finD99 = strrpos($salida2, "[3075]");
  $finD99 = $finD99 - strlen($salida2);
  $D99 = substr($salida2, $inicioD99,  $finD99);
echo "P99=$D99";
  $inicioD100 = strrpos($salida2, "[3075]")+6;
  $finD100 = strrpos($salida2, "[3076]");
  $finD100 = $finD100 - strlen($salida2);
  $D100 = substr($salida2, $inicioD100,  $finD100);
echo "P100=$D100";
  $inicioD101 = strrpos($salida2, "[3076]")+6;
  $finD101 = strrpos($salida2, "[3077]");
  $finD101 = $finD101 - strlen($salida2);
  $D101 = substr($salida2, $inicioD101,  $finD101);
echo "P101=$D101";
  $inicioD102 = strrpos($salida2, "[3077]")+6;
  $finD102 = strrpos($salida2, "[3078]");
  $finD102 = $finD102 - strlen($salida2);
  $D102 = substr($salida2, $inicioD102,  $finD102);
echo "P102=$D102";
  $inicioD103 = strrpos($salida2, "[3078]")+6;
  $finD103 = strrpos($salida2, "[3079]");
  $finD103 = $finD103 - strlen($salida2);
  $D103 = substr($salida2, $inicioD103,  $finD103);
echo "P103=$D103";
  $inicioD104 = strrpos($salida2, "[3079]")+6;
  $finD104 = strrpos($salida2, "[3080]");
  $finD104 = $finD104 - strlen($salida2);
  $D104 = substr($salida2, $inicioD104,  $finD104);
echo "P104=$D104";
  $inicioD105 = strrpos($salida2, "[3080]")+6;
  $finD105 = strrpos($salida2, "[3081]");
  $finD105 = $finD105 - strlen($salida2);
  $D105 = substr($salida2, $inicioD105,  $finD105);
echo "P105=$D105";
  $inicioD106 = strrpos($salida2, "[3081]")+6;
  $finD106 = strrpos($salida2, "[3082]");
  $finD106 = $finD106 - strlen($salida2);
  $D106 = substr($salida2, $inicioD106,  $finD106);
echo "P106=$D106";
  $inicioD107 = strrpos($salida2, "[3082]")+6;
  $finD107 = strrpos($salida2, "[3083]");
  $finD107 = $finD107 - strlen($salida2);
  $D107 = substr($salida2, $inicioD107,  $finD107);
echo "P107=$D107";
  $inicioD108 = strrpos($salida2, "[3083]")+6;
  $finD108 = strrpos($salida2, "[3084]");
  $finD108 = $finD108 - strlen($salida2);
  $D108 = substr($salida2, $inicioD108,  $finD108);
echo "P108=$D108";
  $inicioD109 = strrpos($salida2, "[3084]")+6;
  $finD109 = strrpos($salida2, "[3085]");
  $finD109 = $finD109 - strlen($salida2);
  $D109 = substr($salida2, $inicioD109,  $finD109);
echo "P109=$D109";
  $inicioD110 = strrpos($salida2, "[3085]")+6;
  $finD110 = strrpos($salida2, "[3086]");
  $finD110 = $finD110 - strlen($salida2);
  $D110 = substr($salida2, $inicioD110,  $finD110);
echo "P110=$D110";
  $inicioD111 = strrpos($salida2, "[3086]")+6;
  $finD111 = strrpos($salida2, "[3087]");
  $finD111 = $finD111 - strlen($salida2);
  $D111 = substr($salida2, $inicioD111,  $finD111);
echo "P111=$D111";
  $inicioD112 = strrpos($salida2, "[3087]")+6;
  $finD112 = strrpos($salida2, "[3088]");
  $finD112 = $finD112 - strlen($salida2);
  $D112 = substr($salida2, $inicioD112,  $finD112);
echo "P112=$D112";
  $inicioD113 = strrpos($salida2, "[3088]")+6;
  $finD113 = strrpos($salida2, "[3089]");
  $finD113 = $finD113 - strlen($salida2);
  $D113 = substr($salida2, $inicioD113,  $finD113);
echo "P113=$D113";
  $inicioD114 = strrpos($salida2, "[3089]")+6;
  $finD114 = strrpos($salida2, "[3090]");
  $finD114 = $finD114 - strlen($salida2);
  $D114 = substr($salida2, $inicioD114,  $finD114);
echo "P114=$D114";
  $inicioD115 = strrpos($salida2, "[3090]")+6;
  $finD115 = strrpos($salida2, "[3091]");
  $finD115 = $finD115 - strlen($salida2);
  $D115 = substr($salida2, $inicioD115,  $finD115);
echo "P115=$D115";
  $inicioD116 = strrpos($salida2, "[3091]")+6;
  $finD116 = strrpos($salida2, "[3092]");
  $finD116 = $finD116 - strlen($salida2);
  $D116 = substr($salida2, $inicioD116,  $finD116);
echo "P116=$D116";
  $inicioD117 = strrpos($salida2, "[3092]")+6;
  $finD117 = strrpos($salida2, "[3093]");
  $finD117 = $finD117 - strlen($salida2);
  $D117 = substr($salida2, $inicioD117,  $finD117);
echo "P117=$D117";
  $inicioD118 = strrpos($salida2, "[3093]")+6;
  $finD118 = strrpos($salida2, "[3094]");
  $finD118 = $finD118 - strlen($salida2);
  $D118 = substr($salida2, $inicioD118,  $finD118);
echo "P118=$D118";
$salida3 = shell_exec("/usr/src/modpoll/linux_x86-64/modpoll -m enc -t4:hex -a $IDREM  -r 3110 -c 4 -1 -o 1 $IP -p 1024");
  $inicioD119 = strrpos($salida3, "[3110]")+6;
  $finD119 = strrpos($salida3, "[3111]");
  $finD119 = $finD119 - strlen($salida3);
  $D119 = substr($salida3, $inicioD119,  $finD119);
echo "P119=$D119";
  $inicioD120 = strrpos($salida3, "[3111]")+6;
  $finD120 = strrpos($salida3, "[3112]");
  $finD120 = $finD120 - strlen($salida3);
  $D120 = substr($salida3, $inicioD120,  $finD120);
echo "P120=$D120";
$salida4 = shell_exec("/usr/src/modpoll/linux_x86-64/modpoll -m enc -t4:hex -a $IDREM  -r 3192 -c 6 -1 -o 1 $IP -p 1024");
  $inicioD121 = strrpos($salida4, "[3192]")+6;
  $finD121 = strrpos($salida4, "[3193]");
  $finD121 = $finD121 - strlen($salida4);
  $D121 = substr($salida4, $inicioD121,  $finD121);
echo "P121=$D121";
  $inicioD122 = strrpos($salida4, "[3193]")+6;
  $finD122 = strrpos($salida4, "[3194]");
  $finD122 = $finD122 - strlen($salida4);
  $D122 = substr($salida4, $inicioD122,  $finD122);
echo "P122=$D122";
  $inicioD123 = strrpos($salida4, "[3194]")+6;
  $finD123 = strrpos($salida4, "[3195]");
  $finD123 = $finD123 - strlen($salida4);
  $D123 = substr($salida4, $inicioD123,  $finD123);
echo "P123=$D123";
  $inicioD124 = strrpos($salida4, "[3195]")+6;
  $finD124 = strrpos($salida4, "[3196]");
  $finD124 = $finD124 - strlen($salida4);
  $D124 = substr($salida4, $inicioD124,  $finD124);
echo "P124=$D124";

$v1 = substr("$D1",2);
$v2 = substr("$D2",2);
$deci1= hexdec("$v1$v2");
$hexa1= dechex("$deci1");
$x1 = new Application_Model_Binary("$hexa1");
$DT1 = $x1->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT1=$DT1";
$v3 = substr("$D3",2);
$v4 = substr("$D4",2);
$deci2= hexdec("$v3$v4");
$hexa2= dechex("$deci2");
$x2 = new Application_Model_Binary("$hexa2");
$DT2 = $x2->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT2=$DT2";
$v5 = substr("$D5",2);
$v6 = substr("$D6",2);
$deci3= hexdec("$v5$v6");
$hexa3= dechex("$deci3");
$x3 = new Application_Model_Binary("$hexa3");
$DT3 = $x3->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT3=$DT3";
$v7 = substr("$D7",2);
$v8 = substr("$D8",2);
$deci4= hexdec("$v7$v8");
$hexa4= dechex("$deci4");
$x4 = new Application_Model_Binary("$hexa4");
$DT4 = $x4->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT4=$DT4";
$v9 = substr("$D9",2);
$v10 = substr("$D10",2);
$deci5= hexdec("$v9$v10");
$hexa5= dechex("$deci5");
$x5 = new Application_Model_Binary("$hexa5");
$DT5 = $x5->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT5=$DT5";
$v11 = substr("$D11",2);
$v12 = substr("$D12",2);
$deci6= hexdec("$v11$v12");
$hexa6= dechex("$deci6");
$x6 = new Application_Model_Binary("$hexa6");
$DT6 = $x6->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT6=$DT6";
$v13 = substr("$D13",2);
$v14 = substr("$D14",2);
$deci7= hexdec("$v13$v14");
$hexa7= dechex("$deci7");
$x7 = new Application_Model_Binary("$hexa7");
$DT7 = $x7->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT7=$DT7";
$v15 = substr("$D15",2);
$v16 = substr("$D16",2);
$deci8= hexdec("$v15$v16");
$hexa8= dechex("$deci8");
$x8 = new Application_Model_Binary("$hexa8");
$DT8 = $x8->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT8=$DT8";
$v17 = substr("$D17",2);
$v18 = substr("$D18",2);
$deci9= hexdec("$v17$v18");
$hexa9= dechex("$deci9");
$x9 = new Application_Model_Binary("$hexa9");
$DT9 = $x9->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT9=$DT9";
$v19 = substr("$D19",2);
$v20 = substr("$D20",2);
$deci10= hexdec("$v19$v20");
$hexa10= dechex("$deci10");
$x10 = new Application_Model_Binary("$hexa10");
$DT10 = $x10->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT10=$DT10";
$v21 = substr("$D21",2);
$v22 = substr("$D22",2);
$deci11= hexdec("$v21$v22");
$hexa11= dechex("$deci11");
$x11 = new Application_Model_Binary("$hexa11");
$DT11 = $x11->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT11=$DT11";
$v23 = substr("$D23",2);
$v24 = substr("$D24",2);
$deci12= hexdec("$v23$v24");
$hexa12= dechex("$deci12");
$x12 = new Application_Model_Binary("$hexa12");
$DT12 = $x12->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT12=$DT12";
$v25 = substr("$D25",2);
$v26 = substr("$D26",2);
$deci13= hexdec("$v25$v26");
$hexa13= dechex("$deci13");
$x13 = new Application_Model_Binary("$hexa13");
$DT13 = $x13->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT25=$DT25";
$v27 = substr("$D27",2);
$v28 = substr("$D28",2);
$deci14= hexdec("$v27$v28");
$hexa14= dechex("$deci14");
$x14 = new Application_Model_Binary("$hexa14");
$DT14 = $x14->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT14=$DT14";
$v29 = substr("$D29",2);
$v30 = substr("$D30",2);
$deci15= hexdec("$v29$v30");
$hexa15= dechex("$deci15");
$x15 = new Application_Model_Binary("$hexa15");
$DT15 = $x15->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT15=$DT15";
$v31 = substr("$D31",2);
$v32 = substr("$D32",2);
$deci16= hexdec("$v31$v32");
$hexa16= dechex("$deci16");
$x16 = new Application_Model_Binary("$hexa16");
$DT16 = $x16->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT16=$DT16";
$v33 = substr("$D33",2);
$v34 = substr("$D34",2);
$deci17= hexdec("$v33$v34");
$hexa17= dechex("$deci17");
$x17 = new Application_Model_Binary("$hexa17");
$DT17 = $x17->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT17=$DT17";
$v35 = substr("$D35",2);
$v36 = substr("$D36",2);
$deci18= hexdec("$v35$v36");
$hexa18= dechex("$deci18");
$x18 = new Application_Model_Binary("$hexa18");
$DT18 = $x18->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT18=$DT18";
$v37 = substr("$D37",2);
$v38 = substr("$D38",2);
$deci19= hexdec("$v37$v38");
$hexa19= dechex("$deci19");
$x19 = new Application_Model_Binary("$hexa19");
$DT19 = $x19->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT19=$DT19";
$v39 = substr("$D39",2);
$v40 = substr("$D40",2);
$deci20= hexdec("$v39$v40");
$hexa20= dechex("$deci20");
$x20 = new Application_Model_Binary("$hexa20");
$DT20 = $x20->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT20=$DT20";
$v41 = substr("$D41",2);
$v42 = substr("$D42",2);
$deci21= hexdec("$v41$v42");
$hexa21= dechex("$deci21");
$x21 = new Application_Model_Binary("$hexa21");
$DT21 = $x21->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT21=$DT21";
$v43 = substr("$D43",2);
$v44 = substr("$D44",2);
$deci22= hexdec("$v43$v44");
$hexa22= dechex("$deci22");
$x22 = new Application_Model_Binary("$hexa22");
$DT22 = $x22->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT22=$DT22";
$v45 = substr("$D45",2);
$v46 = substr("$D46",2);
$deci23= hexdec("$v45$v46");
$hexa23= dechex("$deci23");
$x23 = new Application_Model_Binary("$hexa23");
$DT23 = $x23->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT23=$DT23";
$v47 = substr("$D47",2);
$v48 = substr("$D48",2);
$deci24= hexdec("$v47$v48");
$hexa24= dechex("$deci24");
$x24 = new Application_Model_Binary("$hexa24");
$DT24 = $x24->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT24=$DT24";
$v49 = substr("$D49",2);
$v50 = substr("$D50",2);
$deci25= hexdec("$v49$v50");
$hexa25= dechex("$deci25");
$x25 = new Application_Model_Binary("$hexa25");
$DT25 = $x25->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT25=$DT25";
$v51 = substr("$D51",2);
$v52 = substr("$D52",2);
$deci26= hexdec("$v51$v52");
$hexa26= dechex("$deci26");
$x26 = new Application_Model_Binary("$hexa26");
$DT26 = $x26->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT26=$DT26";
$v53 = substr("$D53",2);
$v54 = substr("$D54",2);
$deci27= hexdec("$v53$v54");
$hexa27= dechex("$deci27");
$x27 = new Application_Model_Binary("$hexa27");
$DT27 = $x27->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT27=$DT27";
$v55 = substr("$D55",2);
$v56 = substr("$D56",2);
$deci28= hexdec("$v55$v56");
$hexa28= dechex("$deci28");
$x28 = new Application_Model_Binary("$hexa28");
$DT28 = $x28->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT28=$DT28";
$v57 = substr("$D57",2);
$v58 = substr("$D58",2);
$deci29= hexdec("$v57$v58");
$hexa29= dechex("$deci29");
$x29 = new Application_Model_Binary("$hexa29");
$DT29 = $x29->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT29=$DT29";
$v59 = substr("$D59",2);
$v60 = substr("$D60",2);
$deci30= hexdec("$v59$v60");
$hexa30= dechex("$deci30");
$x30 = new Application_Model_Binary("$hexa30");
$DT30 = $x30->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT30=$DT30";
$v61 = substr("$D61",2);
$v62 = substr("$D62",2);
$deci31= hexdec("$v61$v62");
$hexa31= dechex("$deci31");
$x31 = new Application_Model_Binary("$hexa31");
$DT31 = $x31->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT31=$DT31";
$v63 = substr("$D63",2);
$v64 = substr("$D64",2);
$deci32= hexdec("$v63$v64");
$hexa32= dechex("$deci32");
$x32 = new Application_Model_Binary("$hexa32");
$DT32 = $x32->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT32=$DT32";
$v65 = substr("$D65",2);
$v66 = substr("$D66",2);
$deci33= hexdec("$v65$v66");
$hexa33= dechex("$deci33");
$x33 = new Application_Model_Binary("$hexa33");
$DT33 = $x33->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT33=$DT33";
$v67 = substr("$D67",2);
$v68 = substr("$D68",2);
$deci34= hexdec("$v67$v68");
$hexa34= dechex("$deci34");
$x34 = new Application_Model_Binary("$hexa34");
$DT34 = $x34->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT34=$DT34";
$v69 = substr("$D69",2);
$v70 = substr("$D70",2);
$deci35= hexdec("$v69$v70");
$hexa35= dechex("$deci35");
$x35 = new Application_Model_Binary("$hexa35");
$DT35 = $x35->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT35=$DT35";
$v71 = substr("$D71",2);
$v72 = substr("$D72",2);
$deci36= hexdec("$v71$v72");
$hexa36= dechex("$deci36");
$x36 = new Application_Model_Binary("$hexa36");
$DT36 = $x36->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT36=$DT36";
$v73 = substr("$D73",2);
$v74 = substr("$D74",2);
$deci37= hexdec("$v73$v74");
$hexa37= dechex("$deci37");
$x37 = new Application_Model_Binary("$hexa37");
$DT37 = $x37->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT37=$DT37";
$v75 = substr("$D75",2);
$v76 = substr("$D76",2);
$deci38= hexdec("$v75$v76");
$hexa38= dechex("$deci38");
$x38 = new Application_Model_Binary("$hexa38");
$DT38 = $x38->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT38=$DT38";
$v77 = substr("$D77",2);
$v78 = substr("$D78",2);
$deci39= hexdec("$v77$v78");
$hexa39= dechex("$deci39");
$x39 = new Application_Model_Binary("$hexa39");
$DT39 = $x39->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT39=$DT39";
$v79 = substr("$D79",2);
$v80 = substr("$D80",2);
$deci40= hexdec("$v79$v80");
$hexa40= dechex("$deci40");
$x40 = new Application_Model_Binary("$hexa40");
$DT40 = $x40->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT40=$DT40";
$v81 = substr("$D81",2);
$v82 = substr("$D82",2);
$deci41= hexdec("$v81$v82");
$hexa41= dechex("$deci41");
$x41 = new Application_Model_Binary("$hexa41");
$DT41 = $x41->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT41=$DT41";
$v83 = substr("$D83",2);
$v84 = substr("$D84",2);
$deci42= hexdec("$v83$v84");
$hexa42= dechex("$deci42");
$x42 = new Application_Model_Binary("$hexa42");
$DT42 = $x42->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT42=$DT42";
$v85 = substr("$D85",2);
$v86 = substr("$D86",2);
$deci43= hexdec("$v85$v86");
$hexa43= dechex("$deci43");
$x43 = new Application_Model_Binary("$hexa43");
$DT43 = $x43->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT43=$DT43";
$v87 = substr("$D87",2);
$v88 = substr("$D88",2);
$deci44= hexdec("$v87$v88");
$hexa44= dechex("$deci44");
$x44 = new Application_Model_Binary("$hexa44");
$DT44 = $x44->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT44=$DT44";
$v89 = substr("$D89",2);
$v90 = substr("$D90",2);
$deci45= hexdec("$v89$v90");
$hexa45= dechex("$deci45");
$x45 = new Application_Model_Binary("$hexa45");
$DT45 = $x45->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT45=$DT45";
$v91 = substr("$D91",2);
$v92 = substr("$D92",2);
$deci46= hexdec("$v91$v92");
$hexa46= dechex("$deci46");
$x46 = new Application_Model_Binary("$hexa46");
$DT46 = $x46->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT46=$DT46";
$v93 = substr("$D93",2);
$v94 = substr("$D94",2);
$deci47= hexdec("$v93$v94");
$hexa47= dechex("$deci47");
$x47 = new Application_Model_Binary("$hexa47");
$DT47 = $x47->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT47=$DT47";
$v95 = substr("$D95",2);
$v96 = substr("$D96",2);
$deci48= hexdec("$v95$v96");
$hexa48= dechex("$deci48");
$x48 = new Application_Model_Binary("$hexa48");
$DT48 = $x48->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT48=$DT48";
$v97 = substr("$D97",2);
$v98 = substr("$D98",2);
$deci49= hexdec("$v97$v98");
$hexa49= dechex("$deci49");
$x49 = new Application_Model_Binary("$hexa49");
$DT49 = $x49->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT49=$DT49";
$v99 = substr("$D99",2);
$v100 = substr("$D100",2);
$deci50= hexdec("$v99$v100");
$hexa50= dechex("$deci50");
$x50 = new Application_Model_Binary("$hexa50");
$DT50 = $x50->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT50=$DT50";
$v101 = substr("$D101",2);
$v102 = substr("$D102",2);
$deci51= hexdec("$v101$v102");
$hexa51= dechex("$deci51");
$x51 = new Application_Model_Binary("$hexa51");
$DT51 = $x51->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT51=$DT51";
$v103 = substr("$D103",2);
$v104 = substr("$D104",2);
$deci52= hexdec("$v103$v104");
$hexa52= dechex("$deci52");
$x52 = new Application_Model_Binary("$hexa52");
$DT52 = $x52->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT52=$DT52";
$v105 = substr("$D105",2);
$v106 = substr("$D106",2);
$deci53= hexdec("$v105$v106");
$hexa53= dechex("$deci53");
$x53 = new Application_Model_Binary("$hexa53");
$DT53 = $x53->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT53=$DT53";
$v107 = substr("$D107",2);
$v108 = substr("$D108",2);
$deci54= hexdec("$v107$v108");
$hexa54= dechex("$deci54");
$x54 = new Application_Model_Binary("$hexa54");
$DT54 = $x54->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT54=$DT54";
$v109 = substr("$D109",2);
$v110 = substr("$D110",2);
$deci55= hexdec("$v109$v110");
$hexa55= dechex("$deci55");
$x55 = new Application_Model_Binary("$hexa55");
$DT55 = $x55->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT55=$DT55";
$v111 = substr("$D111",2);
$v112 = substr("$D112",2);
$deci56= hexdec("$v111$v112");
$hexa56= dechex("$deci56");
$x56 = new Application_Model_Binary("$hexa56");
$DT56 = $x56->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT56=$DT56";
$v113 = substr("$D113",2);
$v114 = substr("$D114",2);
$deci57= hexdec("$v113$v114");
$hexa57= dechex("$deci57");
$x57 = new Application_Model_Binary("$hexa57");
$DT57 = $x57->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT57=$DT57";
$v115 = substr("$D115",2);
$v116 = substr("$D116",2);
$deci58= hexdec("$v115$v116");
$hexa58= dechex("$deci58");
$x58 = new Application_Model_Binary("$hexa58");
$DT58 = $x58->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT58=$DT58";
$v117 = substr("$D117",2);
$v118 = substr("$D118",2);
$deci59= hexdec("$v117$v118");
$hexa59= dechex("$deci59");
$x59 = new Application_Model_Binary("$hexa59");
$DT59 = $x59->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT59=$DT59";
$v119 = substr("$D119",2);
$v120 = substr("$D120",2);
$deci60= hexdec("$v119$v120");
$hexa60= dechex("$deci60");
$x60 = new Application_Model_Binary("$hexa60");
$DT60 = $x60->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT60=$DT60";
$v121 = substr("$D121",2);
$v122 = substr("$D122",2);
$deci61= hexdec("$v121$v122");
$hexa61= dechex("$deci61");
$x61 = new Application_Model_Binary("$hexa61");
$DT61 = $x61->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT61=$DT61";
$v123 = substr("$D123",2);
$v124 = substr("$D124",2);
$deci62= hexdec("$v123$v124");
$hexa62= dechex("$deci62");
$x62 = new Application_Model_Binary("$hexa62");
$DT62 = $x62->getFloatFromBits(0, Application_Model_Binary::ENDIAN_BIG);
echo "DT62=$DT62";

class Application_Model_Binary
{
    const ENDIAN_BIG = 0;
    const ENDIAN_LITTLE = 1;

    private $bin;

    public function __construct($string, $as_hex = true) {
        if($as_hex){
            $this->bin = $this->hex2bin($string);
        }else{
            $this->bin = $string;
        }
    }

    /**
     * convert hex-string into bin-string
     * @param string $data
     * @return string
     */
    private function hex2bin($data){
        $encoded = '';
        $data_arr = str_split($data, 2);

        foreach($data_arr as $val){
            $binary = base_convert($val, 16, 2);
            $encoded .= str_pad($binary, 8, '0', STR_PAD_LEFT);
        }
        return $encoded;
    }

    /**
     * get integer value out of current binary
     * @param integer $start offset
     * @param integer $length length
     * @return integer
     */
    public function getValueFromBits($start, $length = null){
        return base_convert($this->getBinarySlice($start, $length), 2, 10);
    }

    /**
     * get particular piece of current binary
     * @param integer $start
     * @param integer $length
     * @return string
     */
    public function getBinarySlice($start, $length = null){
        if($length){
            return substr($this->bin, $start, $length);
        }else{
            return substr($this->bin, $start);
        }
    }

    /**
     * bits count
     * @return type
     */
    public function bits(){
        return strlen($this->bin);
    }

    /**
     * get 32-bit float value at particular offset at specific endian type
     * @param integer $offset offset
     * @return float
     */
    public function getFloatFromBits($offset, $mode = self::ENDIAN_BIG){
        if($mode === self::ENDIAN_BIG){
            $sign = $this->getBinarySlice($offset, 1);
            $exp = $this->getBinarySlice($offset + 1, 8);
            $mantissa = "1" . $this->getBinarySlice($offset + 9, 23);
        }else{
            $sign = $this->getBinarySlice($offset + 24, 1);
            $exp = $this->getBinarySlice($offset + 25, 7).$this->getBinarySlice($offset + 16, 1);
            $mantissa = "1" . $this->getBinarySlice($offset + 17, 7) . $this->getBinarySlice($offset + 8, 8) . $this->getBinarySlice($offset, 8);
        }

        $mantissa = str_split($mantissa);
        $exp = bindec($exp) - 127;
        $base = 0;

        for ($i = 0; $i < 24; $i++) {
            $base += (1 / pow(2, $i))*$mantissa[$i];
        }
        return $base * pow(2, $exp) * ($sign*-2+1);
    }
}




////conexion mysql
$servername = "localhost";
$database = "bodenor";
$username = "ingetel";
$password = "ingetel5454";
$fecha = date("Y-m-d H:i:s");
$fecha2 = date("Y-m-d");
$anio = date("Y");
$mes = date("m");
$dia = date("d");
$hora2 = date("H:i:s");
$hora = date("H");
$min = date("i");
$seg = date("s");
//$idequipo= "101";
$idequipo= $EQUIPO .$IDREM;
echo $fecha;
$conn0 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
if (!$conn0) {
      die("Connection failed: " . mysqli_connect_error());
}
$sql0 = "SELECT `EnergiaActivaConsumida_KWH` , `PotenciaActivaTotal_KW` FROM CONSUMO WHERE `REMARCADOR_ID` = '$idequipo' AND `TIMESTAMP` < '$fecha' ORDER BY `TIMESTAMP` DESC LIMIT 1";
	$ULTIMO= mysqli_query($conn0, $sql0) or die(mysqli_error($conn0));
	$row1 = mysqli_fetch_assoc($ULTIMO);
	$EnergiaActivaConsumida_KWHultimo=$row1['EnergiaActivaConsumida_KWH'];
	$PotenciaActivaTotal_KWultimo=$row1['PotenciaActivaTotal_KW'];
//     echo "select anterior successfully '$EnergiaActivaConsumida_KWHultimo'-'$PotenciaActivaTotal_KWultimo'";
//// Create connection
$conn = mysqli_connect($servername, $username, $password, $database);
//// Check connection
if (!$conn) {
      die("Connection failed: " . mysqli_connect_error());
}

echo "Connected successfully";

$sql = "INSERT INTO schneiderPM5300 (TIMESTAMP,EQUIPO_ID,ITEM1,ITEM2,ITEM3,ITEM4,ITEM5,ITEM6,ITEM7,ITEM8,ITEM9,ITEM10,ITEM11,ITEM12,ITEM13,ITEM14,ITEM15,ITEM16,ITEM17,ITEM18,ITEM19,ITEM20,ITEM21,ITEM22,ITEM23,ITEM24,ITEM25,ITEM26,ITEM27,ITEM28,ITEM29,ITEM30,ITEM31,ITEM32,ITEM33,ITEM34,ITEM35,ITEM36,ITEM37,ITEM38,ITEM39,ITEM40,ITEM41,ITEM42,ITEM43,ITEM44,ITEM45,ITEM46,ITEM47,ITEM48,ITEM49,ITEM50,ITEM51,ITEM52,ITEM53,ITEM54,ITEM55,ITEM56,ITEM57,ITEM58,ITEM59,ITEM60,ITEM61,ITEM62,FECHA,ANIO,MES,DIA,HORA,HH,MM,SS) VALUES ('$fecha','$idequipo','$DT1','$DT2','$DT3','$DT4','$DT5','$DT6','$DT7','$DT8','$DT9','$DT10','$DT11','$DT12','$DT13','$DT14','$DT15','$DT16','$DT17','$DT18','$DT19','$DT20','$DT21','$DT22','$DT23','$DT24','$DT25','$DT26','$DT27','$DT28','$DT29','$DT30','$DT31','$DT32','$DT33','$DT34','$DT35','$DT36','$DT37','$DT38','$DT39','$DT40','$DT41','$DT42','$DT43','$DT44','$DT45','$DT46','$DT47','$DT48','$DT49','$DT50','$DT51','$DT52','$DT53','$DT54','$DT55','$DT56','$DT57','$DT58','$DT59','$DT60','$DT61','$DT62','$fecha2','$anio','$mes','$dia','$hora2','$hora','$min','$seg')";
if (mysqli_query($conn, $sql)) {
      echo "New record created successfully";
} else {
      echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
if ((empty($D1) & empty($D2)) or (empty($D85) & empty($D86))){
          echo "Variables no definidas!!!";
//// Create connection
$conn10 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
if (!$conn10) {
      die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
$sql10= "INSERT INTO CONSUMO (`TIMESTAMP`, `REMARCADOR_ID`, `EnergiaActivaConsumida_KWH`, `PotenciaActivaTotal_KW`, `FECHA`, `ANIO`, `MES`, `DIA`, `HORA`, `HH`, `MM`, `SS`, `DATONULO`) VALUES ('$fecha','$idequipo', '$EnergiaActivaConsumida_KWHultimo' , '$PotenciaActivaTotal_KWultimo' ,'$fecha2','$anio','$mes','$dia','$hora2','$hora','$min','$seg','1')";
if (mysqli_query($conn10, $sql10)) {
      echo "New record created successfully10 ";
      echo "'$fecha','$idequipo', '$EnergiaActivaConsumida_KWHultimo' , '$PotenciaActivaTotal_KWultimo' ,'$fecha2','$anio','$mes','$dia','$hora2','$hora','$min','$seg'";

} else {
      echo "Error: " . $sql10 . "<br>" . mysqli_error($conn10);

}

}elseif ( $D1 != ' ' & $D2 != ' ' & $D85 != ' ' & $D86 != ' '){
//// Create connection
$conn2 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
if (!$conn2) {
      die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
$sql2= "INSERT INTO CONSUMO (`TIMESTAMP`, `REMARCADOR_ID`, `EnergiaActivaConsumida_KWH`, `PotenciaActivaTotal_KW`, `FECHA`, `ANIO`, `MES`, `DIA`, `HORA`, `HH`, `MM`, `SS`) SELECT `TIMESTAMP` , `EQUIPO_ID` , cast(ITEM1 as decimal(27,2)) , cast(ITEM43 as decimal (27,2)) , `FECHA` , `ANIO` , `MES` , `DIA` , `HORA` , `HH` , `MM` , `SS` FROM `schneiderPM5300` WHERE NOT EXISTS ( SELECT * FROM CONSUMO WHERE `REMARCADOR_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha' )  AND `EQUIPO_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha'";
if (mysqli_query($conn2, $sql2)) {
      echo "New record created successfully2";

} else {
      echo "Error: " . $sql2 . "<br>" . mysqli_error($conn2);
}
//elseif ($D2 > 0 & $D1 != ' ' & $D2 != ' ' & $D108 != ' ' & $D109 != ' ' ){
//// Create connection
//$conn3 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
//if (!$conn3) {
//      die("Connection failed: " . mysqli_connect_error());
//}
//echo "Connected successfully";
//$sql3= "INSERT INTO CONSUMO (`TIMESTAMP`, `REMARCADOR_ID`, `EnergiaActivaConsumida_KWH`, `PotenciaActivaTotal_KW`, `FECHA`, `ANIO`, `MES`, `DIA`, `HORA`, `HH`, `MM`, `SS`) SELECT `TIMESTAMP` , `EQUIPO_ID` , cast(( ( ITEM1 *65536 ) + ( ITEM2 ) ) * POWER( 10, ITEM109 ) as decimal(27,2)) , cast(( ITEM7 ) * POWER( 10, ITEM108 ) as decimal(27,2)), `FECHA` , `ANIO` , `MES` , `DIA` , `HORA` , `HH` , `MM` , `SS` FROM `schneiderPM710` WHERE NOT EXISTS ( SELECT * FROM CONSUMO WHERE `REMARCADOR_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha' ) AND `ITEM2` > 0 AND `ITEM2` IS NOT NULL AND `ITEM2` != ' ' AND `ITEM7` IS NOT NULL AND `ITEM7` != ' ' AND `ITEM108` IS NOT NULL AND `ITEM108` != ' ' AND `ITEM109` IS NOT NULL AND `ITEM109` != ' ' AND `EQUIPO_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha'";
//if (mysqli_query($conn3, $sql3)) {
//      echo "New record created successfully3";
//
//} else {
//      echo "Error: " . $sql3 . "<br>" . mysqli_error($conn3);
//}
//}
//elseif (intval($D2) == 0 & $D1 != ' ' & $D2 != ' ' & $D108 != ' ' & $D109 != ' ' ){
//// Create connection
//$conn4 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
//if (!$conn4) {
//      die("Connection failed: " . mysqli_connect_error());
//}
//echo "Connected successfully";
//$sql4= "INSERT INTO CONSUMO (`TIMESTAMP`, `REMARCADOR_ID`, `EnergiaActivaConsumida_KWH`, `PotenciaActivaTotal_KW`, `FECHA`, `ANIO`, `MES`, `DIA`, `HORA`, `HH`, `MM`, `SS`) SELECT `TIMESTAMP` , `EQUIPO_ID` , cast( ( ( ITEM1 *65536 ) + ( ITEM2 ) ) * POWER( 10, ITEM109 ) as decimal(27,2)) , cast(( ITEM7 ) * POWER( 10, ITEM108 ) as decimal(27,2)), `FECHA` , `ANIO` , `MES` , `DIA` , `HORA` , `HH` , `MM` , `SS` FROM `schneiderPM710` WHERE NOT EXISTS ( SELECT * FROM CONSUMO WHERE `REMARCADOR_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha' ) AND `ITEM2` = 0 AND `ITEM2` IS NOT NULL AND `ITEM2` != ' ' AND `ITEM7` IS NOT NULL AND `ITEM7` != ' ' AND `ITEM108` IS NOT NULL AND `ITEM108` != ' ' AND `ITEM109` IS NOT NULL AND `ITEM109` != ' ' AND `EQUIPO_ID` = '$idequipo' AND `TIMESTAMP` = '$fecha'";
//if (mysqli_query($conn4, $sql4)) {
//      echo "New record created successfully4";
//
//} else {
//      echo "Error: " . $sql4 . "<br>" . mysqli_error($conn4);
//}
//}
//
//
}else {
//// Create connection
$conn10 = mysqli_connect($servername, $username, $password, $database);
//// Check connection
if (!$conn10) {
      die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
$sql10= "INSERT INTO CONSUMO (`TIMESTAMP`, `REMARCADOR_ID`, `EnergiaActivaConsumida_KWH`, `PotenciaActivaTotal_KW`, `FECHA`, `ANIO`, `MES`, `DIA`, `HORA`, `HH`, `MM`, `SS`) VALUES ('$fecha','$idequipo', '$EnergiaActivaConsumida_KWHultimo' , '$PotenciaActivaTotal_KWultimo' ,'$fecha2','$anio','$mes','$dia','$hora2','$hora','$min','$seg')";
if (mysqli_query($conn10, $sql10)) {
      echo "New record created successfully10 ";
      echo "'$fecha','$idequipo', '$EnergiaActivaConsumida_KWHultimo' , '$PotenciaActivaTotal_KWultimo' ,'$fecha2','$anio','$mes','$dia','$hora2','$hora','$min','$seg'";
//
} else {
      echo "Error: " . $sql10 . "<br>" . mysqli_error($conn10);
}
}

?>

