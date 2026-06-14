<?php
if (session_status() === PHP_SESSION_NONE) { session_start(); }
$_SESSION['user_name'] = 'Консольный Режим';
echo "\n=========================================\n";
echo "👤 ТЕКУЩИЙ СЕАНС (КОНСОЛЬ CLI): " . $_SESSION['user_name'] . "\n";
echo "=========================================\n\n";
