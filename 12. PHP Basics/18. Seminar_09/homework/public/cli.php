<?php
if (session_status() === PHP_SESSION_NONE) { session_start(); }
$_SESSION['user_name'] = 'Монолитный Консольный Режим';
echo "\n=========================================\n";
echo "👤 ТЕКУЩИЙ СЕАНС (КОНСОЛЬ CLI): " . $_SESSION['user_name'] . "\n";
echo "=========================================\n\n";
