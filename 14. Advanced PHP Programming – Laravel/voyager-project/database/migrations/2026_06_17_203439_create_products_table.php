<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
public function up(): void
{
    Schema::create('products', function (Blueprint $table) {
        $table->id();
        $table->string('sku')->unique();
        $table->string('name');

        // Создаем поле типа INT UNSIGNED (строго под формат Voyager)
        $table->integer('category_id')->unsigned();

        $table->timestamps();

        // Настраиваем внешний ключ вручную
        $table->foreign('category_id')->references('id')->on('categories')->onDelete('cascade');
    });
}


    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('products');
    }
};
